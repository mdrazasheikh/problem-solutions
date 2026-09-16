package design.db.livecoding;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem.java with the review findings fixed in place. Same structure and the same
 * class and method names throughout — only what a finding called out has changed, and
 * each change is marked FIX at the site of the original defect.
 */
class Solution {

    public static class EventDispatcher {

        private static final Logger LOG = System.getLogger(EventDispatcher.class.getName());

        // FIX: volatile. Without it the locking below is still broken, because another
        // thread can see a non-null reference to a partially constructed instance.
        // A holder class or an injected instance would be better; the singleton is kept
        // here to show the locking fix rather than sidestep it.
        private static volatile EventDispatcher instance;

        // FIX: was a plain ArrayList mutated during iteration. Copy-on-write suits a
        // read-mostly registry and makes registering during a dispatch safe.
        private final List<EventListener> listeners = new CopyOnWriteArrayList<>();

        // FIX: real double-checked locking — the null check is repeated inside the lock,
        // so two threads can no longer each construct an instance. The local means the
        // volatile field is read once on the hot path.
        public static EventDispatcher getInstance() {
            EventDispatcher result = instance;
            if (result == null) {
                synchronized (EventDispatcher.class) {
                    result = instance;
                    if (result == null) {
                        result = new EventDispatcher();
                        instance = result;
                    }
                }
            }
            return result;
        }

        // FIX: reject null here, at the call site actually at fault, instead of failing
        // later inside fireEvent.
        public void registerListener(EventListener listener) {
            Objects.requireNonNull(listener, "listener");
            listeners.add(listener);
        }

        // FIX: added. Without it the process-lifetime singleton pins every listener
        // forever — the lapsed-listener leak.
        public void unregisterListener(EventListener listener) {
            listeners.remove(listener);
        }

        // FIX: null check, and each delivery is isolated so one throwing listener no
        // longer aborts the loop and starves the rest. Error is deliberately not caught.
        public void fireEvent(Event event) {
            Objects.requireNonNull(event, "event");
            for (EventListener listener : listeners) {
                try {
                    listener.onEvent(event);
                } catch (RuntimeException e) {
                    LOG.log(Level.WARNING, "Listener " + listener + " failed handling " + event, e);
                }
            }
        }
    }

    public interface EventListener {
        // Delivered on the publisher's thread: implementations must be thread-safe and
        // must not block.
        void onEvent(Event event);
    }

    public static final class Event {

        // FIX: final, so the value is safely published to other threads.
        private final Map<String, Double> payload;

        // FIX: null check and defensive copy. The caller can no longer mutate a payload
        // that listeners are already reading.
        public Event(Map<String, Double> payload) {
            this.payload = Map.copyOf(Objects.requireNonNull(payload, "payload"));
        }

        // FIX: the stored map is now an unmodifiable copy, so handing it out cannot let
        // one listener corrupt what the others see.
        public Map<String, Double> getPayload() {
            return payload;
        }

        // FIX: setPayload removed. A mutable broadcast event is a data race — the
        // publisher could swap the payload mid-dispatch.

        // FIX: added, so "Received event: " + event prints something useful.
        @Override
        public String toString() {
            return "Event" + payload;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Event other && payload.equals(other.payload);
        }

        @Override
        public int hashCode() {
            return payload.hashCode();
        }

        // In Java 21 this class is just:
        //     public record Event(Map<String, Double> payload) {
        //         public Event { payload = Map.copyOf(Objects.requireNonNull(payload)); }
        //     }
        // Written out longhand only to keep the original getPayload() API.
    }

    public static class PubSubTest {

        // FIX: implements Runnable instead of extending Thread. A subscriber is not a
        // thread; an executor owns the scheduling.
        static class Subscriber implements EventListener, Runnable {

            private final CountDownLatch registered;
            private final AtomicInteger received = new AtomicInteger();

            Subscriber(CountDownLatch registered) {
                this.registered = registered;
            }

            @Override
            public void onEvent(Event event) {
                received.incrementAndGet();
            }

            @Override
            public void run() {
                EventDispatcher.getInstance().registerListener(this);
                // FIX: signal that registration is done, so the publisher cannot fire
                // into an empty registry — the start-order race in the original test.
                registered.countDown();
            }

            int received() {
                return received.get();
            }
        }

        static class Publisher implements Runnable {

            static final int EVENTS = 100;

            private final CountDownLatch registered;

            Publisher(CountDownLatch registered) {
                this.registered = registered;
            }

            @Override
            public void run() {
                EventDispatcher dispatcher = EventDispatcher.getInstance();
                try {
                    if (!registered.await(5, TimeUnit.SECONDS)) {
                        throw new IllegalStateException("subscribers never registered");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                for (int i = 0; i < EVENTS; i++) {
                    // FIX: was new Event(new Object()), which did not compile.
                    dispatcher.fireEvent(new Event(Map.of("seq", (double) i)));
                }
            }
        }
    }

    // FIX: @Test dropped — it was unimported and this project has no JUnit dependency,
    // which was one of the two compile errors. With JUnit on the classpath this method
    // carries @Test and the prints below become assertEquals.
    public void test() throws InterruptedException {
        int subscriberCount = 3;
        CountDownLatch registered = new CountDownLatch(subscriberCount);
        List<PubSubTest.Subscriber> subscribers = new ArrayList<>();

        // FIX: an ExecutorService owns the threads, so there is a shutdown path and a
        // way to await completion. Raw Thread.start() offered neither.
        ExecutorService pool = Executors.newFixedThreadPool(subscriberCount + 1);
        for (int i = 0; i < subscriberCount; i++) {
            PubSubTest.Subscriber subscriber = new PubSubTest.Subscriber(registered);
            subscribers.add(subscriber);
            pool.execute(subscriber);
        }
        pool.execute(new PubSubTest.Publisher(registered));

        pool.shutdown();
        if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
            pool.shutdownNow();
            throw new IllegalStateException("dispatch did not finish in time");
        }

        // FIX: the original started two threads and returned, so it passed whether or not
        // a single event was delivered. Now the delivery count is actually checked.
        int delivered = 0;
        for (PubSubTest.Subscriber subscriber : subscribers) {
            delivered += subscriber.received();
            EventDispatcher.getInstance().unregisterListener(subscriber);
        }
        int expected = subscriberCount * PubSubTest.Publisher.EVENTS;

        System.out.println("published  : " + PubSubTest.Publisher.EVENTS);
        System.out.println("deliveries : " + delivered + " (expected " + expected + ")");
        System.out.println("result     : " + (delivered == expected ? "PASS" : "FAIL"));
    }

    // Proves the two fixes the delivery test above cannot show on its own.
    public void sanityChecks() {
        EventDispatcher dispatcher = EventDispatcher.getInstance();
        AtomicInteger healthy = new AtomicInteger();

        EventListener faulty = event -> {
            throw new IllegalStateException("this listener always fails");
        };
        EventListener good = event -> healthy.incrementAndGet();
        dispatcher.registerListener(faulty);
        dispatcher.registerListener(good);
        dispatcher.fireEvent(new Event(Map.of("price", 42.5)));
        dispatcher.unregisterListener(faulty);
        dispatcher.unregisterListener(good);

        Event event = new Event(Map.of("price", 42.5));
        boolean immutable;
        try {
            event.getPayload().put("hack", 0.0);
            immutable = false;
        } catch (UnsupportedOperationException e) {
            immutable = true;
        }

        System.out.println("survived a throwing listener : " + (healthy.get() == 1));
        System.out.println("payload unmodifiable         : " + immutable);
        System.out.println("event toString               : " + event);
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        solution.test();
        System.out.println();
        solution.sanityChecks();
    }
}

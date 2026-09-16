package design.db.livecoding;

import java.util.ArrayList;
import java.util.Map;

// Please outline:
// Obvious bugs
// Potential problems with that particular implementation
// Changes required to make this code production-ready

// REVIEW — does not compile: Event ctor takes Map but is given Object, and @Test is
// not imported (no JUnit on the classpath).
// Bugs ......... broken DCL, non-volatile singleton, unsynchronized listener list,
//                start-order race, Event has no toString.
// Risks ........ mutable shared Event, no listener removal, one throwing listener
//                kills the dispatch, singleton blocks testing.
// Production ... immutable event (record), CopyOnWriteArrayList, DI over singleton,
//                executor over raw Threads, real logger, per-listener error isolation.

// [DESIGN] Unrelated types in one file named 'MyCode'. Split them; PubSubTest belongs
// in src/test/java.
class MyCode {
    public static class EventDispatcher {
        // [CONCURRENCY] Not volatile — another thread can see a partially constructed
        // instance. Required for double-checked locking to be legal.
        private static EventDispatcher instance;
        // [CONCURRENCY] Plain ArrayList mutated by subscribers while the publisher
        // iterates it: CME or lost writes. Use CopyOnWriteArrayList.
        // [STYLE] Should be `private final List<EventListener>`, diamond operator.
        private ArrayList<EventListener> listeners = new ArrayList<EventListener>();

        // [BUG] Broken double-checked locking: the null check is outside the lock and
        // there is no second check inside. Two threads can each construct an instance,
        // the second overwrites the first, and listeners on the discarded one never fire.
        // [FIX] Holder idiom or a static final field — lazy locking buys nothing here.
        // [DESIGN] Global mutable singleton: can't be reset, mocked, or injected.
        public static EventDispatcher getInstance() {
            // [STYLE] Unbraced if — a future edit falls silently outside the lock.
            if (instance == null)
                synchronized (EventDispatcher.class) {
                    instance = new EventDispatcher();
                }
            return instance;
        }

        // [BUG] No null check; a null listener fails later inside fireEvent, far from
        // the caller at fault. Duplicate registration silently delivers twice.
        // [DESIGN] No unregister — a process-lifetime singleton pins every listener
        // forever (lapsed-listener leak).
        public void registerListener(EventListener listener) {
            listeners.add(listener);
        }

        // [BUG] No null check on event.
        // [CONCURRENCY] Iterating while registerListener mutates from another thread
        // throws CME — both happen concurrently in this test, so it's a live failure.
        // [BUG] No error isolation: one listener throwing aborts the loop and the rest
        // silently miss the event.
        // [DESIGN] Synchronous dispatch on the publisher's thread — one slow listener
        // stalls everyone. Needs an executor with backpressure.
        public void fireEvent(Event event) {
            for (EventListener listener : listeners)
                listener.onEvent(event);
        }
    }

    // [DESIGN] Untyped single-channel bus — every listener gets every event and must
    // filter. Consider EventDispatcher<T> or topic-based subscription.
    public interface EventListener {
        void onEvent(Event event);
    }

    // [DESIGN] Value carrier with no behaviour — should be a record, which gives final
    // fields plus equals/hashCode/toString.
    // [BUG] No toString, so the log below prints MyCode$Event@1b6d3586.
    public static class Event {
        // [CONCURRENCY] Non-final, non-volatile field on an object handed to other
        // threads — listeners may see a stale payload.
        // [DESIGN] Stringly-typed payload permits nulls and NaN and encodes no schema.
        private Map<String, Double> payload;

        // [BUG] No defensive copy and no null check — the caller keeps a live reference
        // and can mutate the payload every listener is reading. Use Map.copyOf.
        public Event(Map<String, Double> payload) {
            this.payload = payload;
        }

        // [BUG] Leaks the internal mutable map; any listener can corrupt what the others
        // see. Return an unmodifiable view.
        public Map<String, Double> getPayload() {
            return payload;
        }

        // [BUG] Agreed. A mutable broadcast event is a data race — the publisher can swap
        // the payload mid-dispatch, so two listeners observe different values for one event.
        // remove setter
        public void setPayload(Map<String, Double> payload) {
            this.payload = payload;
        }
    }

    // [DESIGN] Test scaffolding in src/main/java — this ships. Move to src/test/java.
    public static class PubSubTest {
        // [DESIGN] `extends Thread implements EventListener` conflates two roles. A
        // subscriber is not a thread; implement Runnable and let an executor schedule it.
        static class Subscriber extends Thread implements EventListener {
            // [BUG] Prints Event's default toString — this log carries no information.
            // [PROD] System.out is not logging: no levels, no routing, and it's a
            // synchronized global that contends under load. Use SLF4J.
            // [STYLE] Missing @Override.
            public void onEvent(Event event) {
                System.out.println("Received event: " + event);
            }

            // [DESIGN] The thread exists to make one non-blocking call, then dies.
            // [BUG] Events actually arrive on the publisher's thread, so onEvent must be
            // thread-safe — nothing documents or enforces that.
            public void run() {
                EventDispatcher dispatcher = EventDispatcher.getInstance();
                dispatcher.registerListener(this);
            }
        }

        // [PROD] Raw unmanaged Thread: no name, no UncaughtExceptionHandler, no shutdown,
        // no way to await completion. Use an ExecutorService.
        static class Publisher extends Thread {
            public void run() {
                EventDispatcher dispatcher = EventDispatcher.getInstance();
                // [STYLE] Unbraced for; magic number 100.
                for (int i = 0; i < 100; i++)
                    // [COMPILE ERROR] Object cannot be converted to Map<String,Double>.
                    dispatcher.fireEvent(new Event(new Object()));
            }
        }
    }

    // [COMPILE ERROR] cannot find symbol: class Test — no import, and the project
    // declares no test dependency.
    // [DESIGN] A @Test method on a production class in src/main/java.
    @Test
    // [BUG] Asserts nothing and never joins: starts two threads and returns, so it passes
    // whether or not a single event is delivered.
    // [BUG] Start-order race — the publisher can fire all 100 events before the subscriber
    // registers. Needs a latch for registration, join() on both, then an assertion.
    // [STYLE] `throws Exception` is broader than the body needs.
    public void test() throws Exception {
        new PubSubTest.Subscriber().start();
        new PubSubTest.Publisher().start();
    }
}

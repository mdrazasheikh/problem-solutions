package design.ratechecker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Sliding-window rate limiter.
 *
 * <p>Keeps the timestamp of every accepted request inside the current window. A request is
 * accepted when fewer than {@code maxRequestsInWindow} accepted requests fall within the
 * preceding window; rejected requests are not recorded, so a rejection never extends the
 * period during which the caller stays blocked.
 *
 * <p>The window is half-open: a request at time {@code t} counts requests in
 * {@code (t - window, t]}. A timestamp exactly one window old has left it.
 *
 * <p>Timestamps must be supplied by the caller and must not go backwards. Instances are
 * safe for use by multiple threads.
 */
public class RateChecker {

    private static final int DEFAULT_MAX_REQUESTS = 1_000;
    private static final long DEFAULT_WINDOW_SECONDS = 2;

    private final int maxRequestsInWindow;
    private final long windowMs;

    /** Timestamps of accepted requests, oldest first. */
    private final Deque<Long> accepted = new ArrayDeque<>();

    private long lastSeenMs = Long.MIN_VALUE;

    /** A limiter allowing 1000 requests per 2 seconds. */
    public RateChecker() {
        this(DEFAULT_MAX_REQUESTS, DEFAULT_WINDOW_SECONDS, TimeUnit.SECONDS);
    }

    /**
     * @param maxRequestsInWindow how many requests may be accepted per window; must be positive
     * @param window              the window length, which must be at least one millisecond
     * @param unit                the unit of {@code window}
     */
    public RateChecker(int maxRequestsInWindow, long window, TimeUnit unit) {
        if (maxRequestsInWindow <= 0) {
            throw new IllegalArgumentException(
                    "maxRequestsInWindow must be > 0 but was " + maxRequestsInWindow);
        }
        long windowMs = unit.toMillis(window);
        if (windowMs <= 0) {
            throw new IllegalArgumentException(
                    "window must be at least 1ms but was " + window + " " + unit);
        }
        this.maxRequestsInWindow = maxRequestsInWindow;
        this.windowMs = windowMs;
    }

    /**
     * Called once per inspected request or message send attempt.
     *
     * @param sendingTimeMs when the request was sent, in epoch milliseconds; must not be
     *                      earlier than the previous call's timestamp
     * @return {@code false} if accepting this request would push the number of requests in
     *         the sliding window past the threshold; {@code true} otherwise
     * @throws IllegalArgumentException if {@code sendingTimeMs} moves backwards
     */
    public synchronized boolean checkRequest(long sendingTimeMs) {
        if (sendingTimeMs < lastSeenMs) {
            throw new IllegalArgumentException(
                    "timestamps must not go backwards: " + sendingTimeMs + " < " + lastSeenMs);
        }
        lastSeenMs = sendingTimeMs;

        evictExpired(sendingTimeMs);
        if (accepted.size() >= maxRequestsInWindow) {
            return false;
        }
        accepted.addLast(sendingTimeMs);
        return true;
    }

    /**
     * How many accepted requests fall inside the window ending at {@code asOfMs}. Expired
     * entries are discarded as a side effect, which is how the deque is kept bounded.
     */
    public synchronized int currentWindowSize(long asOfMs) {
        evictExpired(asOfMs);
        return accepted.size();
    }

    /** Drops every timestamp that has fallen out of the window ending at {@code nowMs}. */
    private void evictExpired(long nowMs) {
        long windowStart = nowMs - windowMs;
        while (!accepted.isEmpty() && accepted.peekFirst() <= windowStart) {
            accepted.removeFirst();
        }
    }
}

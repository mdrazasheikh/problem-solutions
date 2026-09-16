package ratechecker;

import java.util.ArrayDeque;
import java.util.Deque;

public class RateChecker {
    private long maxRequestInSlidingWindow = 1_000;
    private long slidingWindowSecs = 2;


    private final Deque<Long> request = new ArrayDeque<>();

    /**
     * It is called for each inspected request or message send attempt.
     * @return false if considered message make total messages count in 'slidingWindowSecs' sliding window more than 'maxRequestInSlidingWindow' messages threshold; true otherwise
     */
    boolean checkRequest(long sendingTimeMs) {
        // window duration
        long now = System.currentTimeMillis();
        long windowStart = now - (slidingWindowSecs * 1_000);

        if(!request.isEmpty() && request.peekFirst() <= windowStart){
            request.removeFirst();
        }

        // exceed the size -> false
        if(request.size() >= maxRequestInSlidingWindow){
            return false;
        }

        // keep adding to the queue
        request.addLast(now);
        return true;

    }
}

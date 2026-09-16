package ratechecker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class RateCheckerTest {

    private static RateChecker limiter(int maxRequests, long windowSeconds) {
        return new RateChecker(maxRequests, windowSeconds, TimeUnit.SECONDS);
    }

    @Test
    void allowsRequestsUpToTheLimit() {
        RateChecker checker = limiter(3, 1);

        assertTrue(checker.checkRequest(0));
        assertTrue(checker.checkRequest(100));
        assertTrue(checker.checkRequest(200));
    }

    @Test
    void rejectsTheRequestThatExceedsTheLimit() {
        RateChecker checker = limiter(3, 1);
        checker.checkRequest(0);
        checker.checkRequest(100);
        checker.checkRequest(200);

        assertFalse(checker.checkRequest(300));
    }

    @Test
    void usesTheSuppliedTimestampRatherThanTheSystemClock() {
        RateChecker checker = limiter(1, 1);

        // Timestamps far in the past must still be honoured, which is impossible
        // if the implementation reads System.currentTimeMillis().
        assertTrue(checker.checkRequest(1_000));
        assertFalse(checker.checkRequest(1_500));
        assertTrue(checker.checkRequest(2_000));
    }

    @Test
    void evictsEveryExpiredTimestampNotJustTheOldest() {
        RateChecker checker = limiter(3, 1);
        checker.checkRequest(0);
        checker.checkRequest(1);
        checker.checkRequest(2);

        // The whole burst has aged out of the window, so the cap is free again.
        assertTrue(checker.checkRequest(2_000));
        assertTrue(checker.checkRequest(2_001));
        assertTrue(checker.checkRequest(2_002));
        assertFalse(checker.checkRequest(2_003));
    }

    @Test
    void windowSlidesOneRequestAtATime() {
        RateChecker checker = limiter(2, 1);
        assertTrue(checker.checkRequest(0));
        assertTrue(checker.checkRequest(500));
        assertFalse(checker.checkRequest(900));

        // At 1000 the request from 0 has left the window, freeing exactly one slot.
        assertTrue(checker.checkRequest(1_000));
        assertFalse(checker.checkRequest(1_100));
    }

    @Test
    void rejectedRequestsDoNotOccupyTheWindow() {
        RateChecker checker = limiter(1, 1);
        assertTrue(checker.checkRequest(0));
        assertFalse(checker.checkRequest(100));
        assertFalse(checker.checkRequest(200));

        // Only the accepted request at 0 counted, so 1000 is allowed.
        assertTrue(checker.checkRequest(1_000));
    }

    @Test
    void reportsHowManyRequestsAreInTheWindow() {
        RateChecker checker = limiter(5, 1);
        checker.checkRequest(0);
        checker.checkRequest(100);

        assertEquals(2, checker.currentWindowSize(100));
        assertEquals(0, checker.currentWindowSize(5_000));
    }

    @Test
    void rejectsOutOfOrderTimestamps() {
        RateChecker checker = limiter(5, 1);
        checker.checkRequest(1_000);

        assertThrows(IllegalArgumentException.class, () -> checker.checkRequest(999));
    }

    @Test
    void rejectsInvalidConfiguration() {
        assertThrows(IllegalArgumentException.class, () -> limiter(0, 1));
        assertThrows(IllegalArgumentException.class, () -> limiter(1, 0));
    }
}

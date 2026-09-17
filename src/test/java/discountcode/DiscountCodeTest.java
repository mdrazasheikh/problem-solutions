package discountcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class DiscountCodeTest {

    @Test
    void returnsOneFlagPerCode() {
        List<Integer> flags = Result1.findValidDiscountCoupons(List.of("daabbd", "abc", "aa"));

        assertEquals(3, flags.size());
    }

    @Test
    void acceptsCodesBuiltByWrappingAndConcatenation() {
        // "daabbd" is d + (aa)(bb) + d; "aabb" is two wrapped empties side by side.
        assertEquals(List.of(1, 1, 1, 1), Result1.findValidDiscountCoupons(
                List.of("daabbd", "aabb", "abba", "aa")));
    }

    @Test
    void rejectsCodesThatCannotBeBuilt() {
        assertEquals(List.of(0, 0, 0), Result1.findValidDiscountCoupons(
                List.of("abc", "aab", "abab")));
    }

    @Test
    void treatsEmptyAndSingleCharacterCodes() {
        assertEquals(List.of(1, 0), Result1.findValidDiscountCoupons(List.of("", "a")));
    }

    @Test
    void handlesAnEmptyCodeList() {
        assertEquals(List.of(), Result1.findValidDiscountCoupons(List.of()));
    }
}

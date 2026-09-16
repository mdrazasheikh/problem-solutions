package stack.discountcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Result1 {

    /*
     * Complete the 'findValidDiscountCoupons' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY discounts as parameter.
     */

    public static List<Integer> findValidDiscountCoupons(List<String> discounts) {
        List<Integer> response = new ArrayList<>();
        for (String code : discounts) {
            response.add(isValidCoupon(code) ? 1 : 0);
        }
        return response;
    }

    /**
     * A coupon is valid when it is empty, or a valid coupon wrapped in a matching pair of
     * characters, or two valid coupons side by side.
     *
     * <p>Every such coupon collapses to nothing if adjacent equal characters are deleted
     * repeatedly, and only such coupons do, so one stack pass decides it: a character that
     * equals the top cancels with it, anything else is pushed.
     */
    static boolean isValidCoupon(String code) {
        if (code == null) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

public class DiscountCode {
    static void main(String[] args) {
        List<String> codes = List.of("daabbd", "abc", "aabb", "abab");

        System.out.println(codes);
        System.out.println(Result1.findValidDiscountCoupons(codes)); // [1, 0, 1, 0]
    }
}

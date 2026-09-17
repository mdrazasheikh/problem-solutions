package validparenthesis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;

public class ValidParenthesis {
    boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        var stack = new ArrayDeque<Character>();
        var matching = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != matching.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    void main(String[] args) {
        System.out.println(isValid("([]{})"));
    }
}

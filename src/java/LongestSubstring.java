package interview;

import java.util.HashMap;

public class LongestSubstring {
    int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        var seen = new HashMap<Character, Integer>();
        var maxlen = 0;
        var left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen.containsKey(c)) {
                left = Math.max(left, seen.get(c) + 1);
            }
            seen.put(c, i);
            maxlen = Math.max(maxlen, i - left + 1);
        }
        return maxlen;
    }

    void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}

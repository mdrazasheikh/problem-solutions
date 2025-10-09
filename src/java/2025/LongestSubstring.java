import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static String lengthOfTheLongestSubstring(String s){
        if (s == null || s.isEmpty()) {
            return "";
        }
        Map<Character, Integer> last = new HashMap<>();
        int maxLen = 0, start = 0, maxStart = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(last.containsKey(c)){
                start = Math.max(start, last.get(c) + 1);
            }
            last.put(c, i);
            int windowLen = i - start + 1;
            if (windowLen > maxLen) {
                maxLen = windowLen;
                maxStart = start;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfTheLongestSubstring("abcabcbb"));
        System.out.println(lengthOfTheLongestSubstring("pwwkew"));
    }
}

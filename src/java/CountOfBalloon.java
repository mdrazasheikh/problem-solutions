package interview;

import java.util.HashMap;
import java.util.Map;

public class CountOfBalloon {
    int countOfBalloon(String str) {
        var orgCharCount = Map.of(
                'b', 1,
                'a', 1,
                'l', 2,
                'o', 2,
                'n', 1
        );

        var charFreq = new HashMap<Character, Integer>();

        for (char c : str.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        int result = Integer.MAX_VALUE;
        for (var entry : orgCharCount.entrySet()) {
            var ch = entry.getKey();
            int required = entry.getValue();
            int available = charFreq.getOrDefault(ch, 0);

            result = Math.min(result, available / required);
        }

        return result;
    }

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        int b = count['b' - 'a'];
        int a = count[0];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }

    void main(String[] args) {
        System.out.println(countOfBalloon("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}

package interview;

import java.util.*;

public class GroupedAnagram {
    List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(word);
        }
        return new ArrayList<>(map.values());
    }

    void main(String[] args) {
        String[] strs = {"eat", "tea", "ate", "tan", "nat", "bat"};

        System.out.println(groupAnagram(strs));
    }
}

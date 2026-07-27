package firstuniquechar;

public class FirstUniqueChar {
    public Character firstUnique(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }

    void main(String[] args) {
        System.out.println(firstUnique("leetcode"));
    }
}

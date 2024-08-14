package java;

public class LinkUniqueChecker {

    public static boolean isSimilar(String link1, String link2) {
        link1 = link1.toLowerCase();
        link2 = link2.toLowerCase();

        if (link1.equals(link2)) {
            return true;
        }

        String compareString, comparatorString;
        if (link2.length() > link1.length()) {
            compareString = link2;
            comparatorString = link1;
        } else {
            compareString = link1;
            comparatorString = link2;
        }

        for (int i = 1; i <= 3; i++) {
            String subStr = comparatorString.substring(i);

            if (compareString.contains(subStr)
                    && compareString.replace(subStr, "").length() < 2
            ) {
                return true;
            }
        }

        for (int i = comparatorString.length(); i >= comparatorString.length() - 4; i--) {
            String subStr = comparatorString.substring(0, i);

            if (compareString.contains(subStr)
                    && compareString.replace(subStr, "").length() < 2
            ) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String link1 = "o9J_l29kLjk=";
        String link2 = "o9J_l29kLjk#";

        System.out.println(isSimilar(link1, link2));
    }
}

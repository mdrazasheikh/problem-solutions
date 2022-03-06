public class LuckyNumber {

    static int counter = 2;

    static boolean isLucky(int n) {
        if (counter > n) {
            return true;
        }

        if (n % counter == 0) {
            return false;
        }

        int nextPosition = n - (n / counter);
        counter++;

        return isLucky(nextPosition);
    }

    public static void main(String[] args) {
        int x = 100;

        if (isLucky(x)) {
            System.out.println(x + " is a lucky number");
        } else {
            System.out.println(x + " is not a lucky number");
        }
    }
}

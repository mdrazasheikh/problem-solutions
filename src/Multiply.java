public class Multiply {

    public static int doMultiply(int x, int y) {
        if (y == 0) {
            return 0;
        }

        if (y > 0) {
            return x + doMultiply(x, y - 1);
        }

        return -doMultiply(x, -y);

    }

    public static void main(String[] args) {
        int x = 2, y = -2;
        int result = doMultiply(x, y);
        System.out.println(result);
    }
}

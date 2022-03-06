public class BinarySearch {

    public static int search(int[] x, int target) {
        int start = 0;
        int end = x.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == x[mid]) {
                return mid;
            }

            if (target > x[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 4, 6, 7, 8, 9};

        System.out.println(search(x, 9));
    }
}

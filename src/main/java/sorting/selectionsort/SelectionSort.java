package sorting.selectionsort;

import java.util.Arrays;

public class SelectionSort {

    public static void swapPosition(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swapPosition(arr, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = {1, 10, 7, 4, 9, 5, 8, 3, 2, 6};

        System.out.println("Array before selection sort: " + Arrays.toString(arrayToSort));

        selectionSort(arrayToSort);

        System.out.println("Array after selection sort: " + Arrays.toString(arrayToSort));
    }
}

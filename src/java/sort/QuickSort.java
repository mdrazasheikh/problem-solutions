package java.sort;

import java.util.Arrays;

public class QuickSort {

    public static void swapPosition(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                swapPosition(arr, i, j);
            }
        }
        swapPosition(arr, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = {1, 10, 7, 4, 9, 5, 8, 3, 2, 6};
        int arrayLength = arrayToSort.length;

        System.out.println("Array before java.sort: " + Arrays.toString(arrayToSort));

        quickSort(arrayToSort, 0, arrayLength - 1);

        System.out.println("Array after java.sort: " + Arrays.toString(arrayToSort));
    }
}

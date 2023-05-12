package danekerscode;

import java.util.Arrays;

public class FourthAssignment {
    public static void task1(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = arr[0];
                arr[0] = max;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task2(int[] arr) { // n(log n)
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.println("repetitive element " + arr[i]);
                return;
            }
        }
        System.out.println("No repetitive element ");
    }

    static class MergeSort {
        static void merge(int[] arr, int l, int m, int r) {
            int[] left = new int[m - l + 1];
            int[] right = new int[r - m];
            System.arraycopy(arr, l, left, 0, left.length);
            for (int j = 0; j < right.length; ++j)
                right[j] = arr[m + 1 + j];
            int i = 0, j = 0;
            int k = l;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
            System.out.println("left side:" + Arrays.toString(left) + " right side " + Arrays.toString(right));
            System.out.println("result after iteration:" + Arrays.toString(arr));
        }

        static void mergeSort(int arr[], int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;
                mergeSort(arr, l, m);
                mergeSort(arr, m + 1, r);
                merge(arr, l, m, r);
            }
        }
    }

    static class QuickSort {
        static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j <= high - 1; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return (i + 1);
        }

        static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
    }

    static class BubbleSort {
        static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        QuickSort.swap(arr, j, j + 1);
                    }
                }
            }
        }
    }

}

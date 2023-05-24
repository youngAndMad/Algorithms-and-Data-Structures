package danekerscode;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingProblems {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("-----------------");
        int m = in.nextInt();
        System.out.println(solution3(m, arr));
    }

    public static long solution1(int a, int[] arr) {
        return Arrays.stream(arr).filter(el -> el == a).count();
    }

    public static boolean solution2(int[] arr, int target, int low, int high) {
        //  return Arrays.stream(arr).anyMatch(a -> a == target);
        if (low > high)
            return false;

        int mid = (low + high) / 2;
        return arr[mid] == target || (arr[mid] < target ? solution2(arr, target, mid + 1, high) : solution2(arr, target, low, mid - 1));
    }

    public static int solution3(int a, int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= a && arr[i + 1] >= a) {
                return a - arr[i] > arr[i + 1] - a ? arr[i + 1] : arr[i];
            }
        }
        return arr[0] > a ? arr[0] : arr[arr.length - 1];
    }

}

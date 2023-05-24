package danekerscode;

import java.util.*;

public class FifthAssignment {
    public static void main(String[] args) {
        // System.out.println(task5way1(new int[]{1, 4, 5, 2, 5, 8, 9, 5, 57, 5, 2, 5, 6, 6, 2, 5, 8, 8, 5, 2, 4, 5}));
        System.out.println(task6way2(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int task5way1(int[] arr) {
        return new LinkedList<Map.Entry<Integer, Integer>>
                (new TreeSet<>(Map.Entry.comparingByValue()) {{
                    addAll(new HashMap<Integer, Integer>() {{
                        Arrays.stream(arr).forEach(a -> {
                            compute(a, (k, v) -> (v == null) ? 1 : ++v); //  O(n)
                        });
                    }}.entrySet());
                }})
                .getLast()
                .getKey();
    }

    public static int task6way1(int[] arr, int target) { // n^3
        int[] res = new int[3];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(target - (arr[i] + arr[j] + arr[k])) < minDiff) {
                        res = new int[]{arr[i], arr[j], arr[k]};
                        minDiff = Math.abs(target - (arr[i] + arr[j] + arr[k]));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return Arrays.stream(res).sum();
    }

    public static int task6way2(int[] arr, int target) {
        Arrays.sort(arr); // n(log n)
        System.out.println("sorted arr:" + Arrays.toString(arr));
        int diff = Integer.MAX_VALUE;
        // both < 0
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1, k = j + 1;
            int tempSum = arr[i] + arr[j] + arr[k];
            int tempDiff = (target < 0 && tempSum < 0) ?
                    Math.abs(Math.max(target, tempSum)) - Math.abs(Math.min(target, tempSum)) :
                    (tempSum > 0 && target > 0) ? Math.abs(target - tempSum) :
                            (tempSum > 0 && target < 0) ? tempSum - Math.abs(target) : target - Math.abs(tempSum);

            System.out.println("temp diff:"+tempDiff);
            System.out.println("abs in range: " + Arrays.toString(Arrays.copyOfRange(arr, i, k + 1)) + " = " + tempDiff);
            if (tempDiff == 0) {
                System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                return target;
            } else {
                diff = Math.min(diff, tempDiff);
            }
        }

        return diff;
    }


}

package danekerscode.SecondAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class AssignmentII {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
    }

    public static void firstTask() {
        List<List<Integer>> list = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            List<Integer> innerList = new ArrayList<>();
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int value = in.nextInt();
                innerList.add(value);
            }
            list.add(innerList);
        }
        System.out.println("final list: " + list);
        int m = in.nextInt();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            res.add(find.apply(list.get(x - 1), y - 1));
        }
        res.forEach(System.out::println);
    }

    static BiFunction<List<Integer>, Integer, String> find = (list, index) -> index > list.size() ? "ERROR" : String.valueOf(list.get(index));

    public static void secondTask() {
        List<Integer> list = new ArrayList<>();

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            list.add(value);
        }

        int q = in.nextInt();
        while (q > 0) {
            String query = in.next();
            int i = in.nextInt();
            switch (query) {
                case "Insert" -> {
                    insert.accept(list, i);
                    System.out.println("after operation {insert}" + list);
                }
                case "Delete" -> {
                    delete.accept(list, i);
                    System.out.println("after operation {delete}" + list);
                }
            }
            q--;
        }
    }

    static BiConsumer<List<Integer>, Integer> delete = (list , i) -> {
        int counter = 0;
        while (counter < i){
            counter++;
        }
        list.remove(counter);
    };

    static BiConsumer<List<Integer>, Integer> insert = (list, i) -> {
        int value = in.nextInt();
        if (i >= list.size()) {
            list.add(value);
        } else {
            list.add(i - 1, value);
        }
    };

    public static void thirdTask() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("array before:" + Arrays.toString(arr));
        reverse(arr, 0);
        System.out.println("array after:" + Arrays.toString(arr));
    }

    static void reverse(int[] arr, int i) {
        if (i >= arr.length / 2) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;

        reverse(arr, i + 1);
    }


}

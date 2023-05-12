package danekerscode;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingProblems {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = solution3(2 , new int[]{
                -4,4,1,2
        });
        System.out.println(a);
    }
    public static long solution1(int a , int [] arr){
        /*Input:
At the first line: number of elements in the array N <= 1000;
At the second line: elements of the array;
At the last line: a number X to be searched.
Output:
An integer number – a number of occurrences of the given number X*/
        return Arrays.stream(arr).filter(el -> el ==a).count();
    }
    public static boolean solution2(int[] arr, int target, int low, int high) {
        /*Input:
At the first line: number of elements in the array N <= 1000;
At the second line: elements of the array;
At the last line: a number X to be searched.
Output:
Print “YES” if a given number exists in a given array, otherwise print “NO”*/
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        return arr[mid] == target || (arr[mid] < target ? solution2(arr, target, mid + 1, high) : solution2(arr, target, low, mid - 1));
    }
    public static int solution3(int a , int [] arr){ //не уверен насчет этого подхода
        /*Write a program that finds an element in a given array nearest to a given integer
number X.
Input:
At the first line: number of elements in the array N <= 1000;
At the second line: elements of the array;
At the last line: an integer number X.
Output:
Print an element of the given array nearest to X. If there are several nearest
numbers in the array, print any of them.*/


      /*  var val = Arrays.stream(arr)
                .map(el -> el - a)
                .map(Math::abs)
                .min().getAsInt();
        return val + a;*/

        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < a && arr[i+1] > a){
                return a + 1;
            }
        }

        return arr[0] < a ? arr[0] : arr[arr.length - 1];


    }

}

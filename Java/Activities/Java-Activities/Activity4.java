package Activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] arr = { 10,9,8,7,6,5 };
        ascendingInsertSort(arr);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(arr));
     }

    static void ascendingInsertSort(int arr[]) {
        int lengthArr = arr.length, i;
//Traverse the array except for 1st element
        for (i = 1; i < lengthArr; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }


}}

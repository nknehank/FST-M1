package Activities;
import java.util.*;

public class Activity2 {

    public static void main(String[] args) {
        int[] arr = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(arr));

        int searchNumber = 10;
        int sumRequired = 30;

        System.out.println("Result required" + calculate(arr, searchNumber, sumRequired));
    }

        public static boolean calculate(int[] arr, int searchNumber, int sumRequired)
        {
            int tempSum = 0;
            //Traverse array
            for (int number : arr) {
                if (number == searchNumber)
                {
                    tempSum = tempSum + searchNumber;

                }

                if (tempSum > sumRequired) {
                    break;
                }
                  }
            return tempSum == sumRequired;
        }
    }

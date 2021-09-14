package Arrays;

import java.util.Scanner;

public class _10_Largest_Sum_Contiguous_Array {

    public int largestSum1(int arr[], int n) {
        int maxSum = Integer.MIN_VALUE;
        int currSum;

        for (int i = 0; i < n; i++) {
            currSum = arr[i];
            for (int j = i + 1; j < n; j++) {
                // if (currSum > maxSum && currSum > currSum + arr[j])
                //     maxSum = currSum;
                // else if (currSum + arr[j] > maxSum)
                //     maxSum = currSum + arr[j];
                maxSum = Math.max(maxSum, Math.max(currSum, currSum + arr[j]));
                currSum += arr[j];
            }

            // checking for last element arr[n-1]
            if (currSum > maxSum)
                maxSum = currSum;
        }
        return maxSum;
    }

    public int largestSum2(int arr[], int n) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum = currSum + arr[i];
            if (maxSum < currSum)
                maxSum = currSum;

            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your array elements :- ");
        String numbers[] = scan.nextLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(numbers[i]);
        }

        _10_Largest_Sum_Contiguous_Array obj = new _10_Largest_Sum_Contiguous_Array();
        int result = obj.largestSum1(arr, n);
        System.out.println("Max sum = " + result);
    }
}

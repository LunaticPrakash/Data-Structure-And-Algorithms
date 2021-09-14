package Arrays;

import java.util.Scanner;

public class _28_Trapping_Rain_Water_Problem {

    private static void display(int[] arr) {
        System.out.println();
        for (int e : arr)
            System.out.print(e + " ");
    }

    private static int getWater(int[] arr, int n) {
        int sum = 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        int ma = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > ma) {
                ma = arr[i];
            }
            maxLeft[i] = ma;
        }

        ma = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > ma) {
                ma = arr[i];
            }
            maxRight[i] = ma;
        }

        for (int i = 0; i < n; i++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - arr[i];
        }

        return sum;
    }

    private static int getWater2(int[] arr, int n) {
        int sum = 0;
        int maxLeft = arr[0];
        int maxRight = arr[n - 1];
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (arr[i] < arr[j]) {
                if (arr[i] > maxLeft) {
                    maxLeft = arr[i];
                    sum += 0;
                }

                else {
                    sum += (maxLeft - arr[i]);
                }
                i++;
            } else {
                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                    sum += 0;
                }

                else {
                    sum += (maxRight - arr[j]);
                }
                j--;
            }
        }
        return sum;
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

        int result = getWater(arr, n);
        System.out.println("Total Water Trapped = " + result);
    }
}

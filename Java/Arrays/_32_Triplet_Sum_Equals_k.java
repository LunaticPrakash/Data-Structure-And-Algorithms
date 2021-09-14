package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _32_Triplet_Sum_Equals_k {

    private static int getTriplet(int arr[], int sum) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == sum)
                        count += 1;
                }
            }
        }
        return count;
    }

    private static int getTriplet2(int arr[], int sum) {
        int count = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == sum) {
                    count += 1;
                    l++;
                    r--;
                } else if (arr[i] + arr[l] + arr[r] > sum)
                    r = r - 1;
                else
                    l = l + 1;
            }
        }
        return count;
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
        System.out.print("Enter value of k : ");
        int k = scan.nextInt();

        System.out.println(getTriplet2(arr, k));
    }
}

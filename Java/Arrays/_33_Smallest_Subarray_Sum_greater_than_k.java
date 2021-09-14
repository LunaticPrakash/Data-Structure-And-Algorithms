import java.util.Scanner;

public class _33_Smallest_Subarray_Sum_greater_than_k {

    private static int getSubarray(int arr[], int k) {
        int n = arr.length;
        int currSum = 0;
        int minLen = n + 1;

        for (int i = 0; i < n; i++) {
            currSum = arr[i];
            if (currSum > k) {
                return 1;
            }
            for (int j = i + 1; j < n; j++) {
                currSum += arr[j];
                if (currSum > k && j - i + 1 < minLen) {
                    minLen = j - i + 1;
                }
            }
        }
        return minLen;
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
        scan.close();
        System.out.println(getSubarray(arr, k));
    }
}

package Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _22_Subarray_Sum_0 {

    private boolean subarraySum(int[] arr, int n) {
        Set<Integer> seen = new HashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0 || arr[i] == 0 || seen.contains(sum))
                return true;
            seen.add(sum);
        }

        return false;
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

        _22_Subarray_Sum_0 obj = new _22_Subarray_Sum_0();
        if (obj.subarraySum(arr, n))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}

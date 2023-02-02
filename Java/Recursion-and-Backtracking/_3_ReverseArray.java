import java.util.Arrays;

public class _3_ReverseArray {
    // Reverse Array: Parameterized Recursion - Time:O(N) Space: O(N){for
    // Recursion}
    public static void reverseArray1(int[] arr, int n, int[] rev, int i) {
        if (i == n)
            return;
        rev[i] = arr[n - 1 - i];
        reverseArray1(arr, n, rev, i + 1);
    }

    // Reverse Array: Parameterized Recursion - Time:O(N) Space: O(N){for
    // Recursion}
    public static void reverseArray2(int[] arr, int start, int end) {
        if (start > end)
            return;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray2(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4};
        int[] rev = new int[4];

        reverseArray1(arr, arr.length, rev, 0);
        System.out.println("Reverse Array (Using Parameterized Recursion, Outplace): " + Arrays.toString(rev));

        reverseArray2(arr, 0, arr.length - 1);
        System.out.println("Reverse Array (Using Parameterized Recursion, Inplace): " + Arrays.toString(arr));
    }
}

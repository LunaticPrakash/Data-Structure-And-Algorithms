import java.util.HashMap;

public class _22LargestSubArray0Sum {

    // Approach - 1 Time: O(N2) Space: O(1)
    public static int maxLen1(int arr[], int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0)
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    // Approach - 2 Time: O(N) Space: O(N)
    public static int maxLen2(int arr[], int n) {
        HashMap<Integer, Integer> prefSum = new HashMap<>();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                max = i + 1;
            else {
                if (prefSum.containsKey(sum)) {
                    max = Math.max(max, i - prefSum.get(sum));
                } else {
                    prefSum.put(sum, i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen2(arr, arr.length));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class subArraySum {

    public static ArrayList<Integer> subArraySumSolver(int[] arr, int targetSum, int n) {
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum = currSum + arr[j];
                if (currSum == targetSum)
                    return new ArrayList<>(Arrays.asList(i, j));
            }
        }
        return null;
    }

    public static ArrayList<Integer> subArraySumSolver2(int[] arr, int targetSum, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum == targetSum) {
                start = 0;
                end = i;
                return new ArrayList<>(Arrays.asList(start, end));
            }

            else if (map.containsKey(currSum - targetSum)) {
                start = map.get(currSum - targetSum) + 1;
                end = i;
                return new ArrayList<>(Arrays.asList(start, end));
            }

            else {
                map.put(currSum, i);
            }
        }
        return new ArrayList<>(Arrays.asList(start, end));
    }

    // Getting number of subarrays whose sum equals targetSum
    public static int subArraySumSolver3(int[] arr, int targetSum, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum == targetSum)
                count++;

            else if (map.containsKey(currSum - targetSum))
                count++;

            map.put(currSum, i);
        }
        return count;
    }

    // Longest Subarray Sum
    public static ArrayList<Integer> subArraySumSolver4(int[] arr, int targetSum, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int start = -1;
        int end = -1;
        int maxLen = -1;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (currSum == targetSum) {
                int tempStart = 0;
                int tempEnd = i;
                if ((tempEnd - tempStart + 1) > maxLen) {
                    maxLen = tempEnd - tempStart + 1;
                    start = tempStart;
                    end = tempEnd;
                    res.clear();
                    res.addAll(Arrays.asList(start, end));
                }
            }

            else if (map.containsKey(currSum - targetSum)) {
                int tempStart = map.get(currSum - targetSum) + 1;
                int tempEnd = i;
                if ((tempEnd - tempStart + 1) > maxLen) {
                    maxLen = tempEnd - tempStart + 1;
                    start = tempStart;
                    end = i;
                    res.clear();
                    res.addAll(Arrays.asList(start, end));
                }
            }

            map.put(currSum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, 3, 7, 5, 1, 2, 1, 3 };
        int[] arr1 = { 77, 32, 9, 45, 40, 27, 24, 38, 39, 19, 83, 30, 42, 34, 16, 40 };
        int targetSum = 12;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        System.out.println("Indexes = " + subArraySumSolver3(arr, targetSum, arr.length));
    }
}

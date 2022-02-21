import java.util.HashMap;

public class canSubsetSum {

    // Simple Recusrion
    public static boolean canSubsetSumSolver(int[] arr, int n, int targetSum) {
        if (targetSum == 0)
            return true;
        else if (targetSum < 0 || n <= 0)
            return false;
        else if (arr[n - 1] > targetSum)
            return canSubsetSumSolver(arr, n - 1, targetSum);
        return canSubsetSumSolver(arr, n - 1, targetSum - arr[n - 1]) || canSubsetSumSolver(arr, n - 1, targetSum);
    }

    // Memoized Solution
    public static boolean canSubsetSumSolver(int[] arr, int n, int targetSum, HashMap<Integer, Boolean> memo) {

        if (targetSum == 0)
            return true;
        else if (targetSum < 0 || n <= 0)
            return false;
        else if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        else if (arr[n - 1] > targetSum){
            memo.put(targetSum, canSubsetSumSolver(arr, n - 1, targetSum, memo));
            return memo.get(targetSum);
        }
        memo.put(targetSum,canSubsetSumSolver(arr, n - 1, targetSum - arr[n - 1], memo)
                || canSubsetSumSolver(arr, n - 1, targetSum, memo));
        return memo.get(targetSum);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int[] arr1 = { 77, 32, 9, 45, 40, 27, 24, 38, 39, 19, 83, 30, 42, 34, 16, 40 };
        int targetSum = 659;
        int n = arr.length;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        System.out.println("CanSubsetSum = " + canSubsetSumSolver(arr, n, 9, memo));

    }
}

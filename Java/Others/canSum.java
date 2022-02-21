import java.util.HashMap;

public class canSum {

    // Simple Recusrion
    public static boolean canSumSolver(int[] arr, int targetSum) {

        if (targetSum == 0)
            return true;
        else if (targetSum < 0)
            return false;
        for (int i = 0; i < arr.length; i++) {
            int remainingSum = targetSum - arr[i];
            if (canSumSolver(arr, remainingSum))
                return true;
        }
        return false;
    }

    // Memoized Solution
    public static boolean canSumSolver(int[] arr, int targetSum, HashMap<Integer, Boolean> memo) {

        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        for (int i = 0; i < arr.length; i++) {
            int remainingSum = targetSum - arr[i];
            Boolean result = canSumSolver(arr, remainingSum, memo);
            if (result == true){
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int targetSum = 30;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        System.out.println("CanSum = " + canSumSolver(arr, targetSum, memo));
    }
}

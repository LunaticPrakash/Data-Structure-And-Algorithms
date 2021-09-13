package Arrays;

import java.util.HashMap;

public class canSum {
    public static boolean canSumSolver(int targetSum, int[] nums, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int n : nums) {
            int rem = targetSum - n;
            if (canSumSolver(rem, nums, memo) == true) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        int[] a1 = { 2, 3 };
        System.out.println(canSumSolver(7, a1, new HashMap<Integer, Boolean>()));
        int[] a2 = { 5, 3, 4, 7 };
        System.out.println(canSumSolver(7, a2, new HashMap<Integer, Boolean>()));
        int[] a3 = { 2, 4 };
        System.out.println(canSumSolver(7, a3, new HashMap<Integer, Boolean>()));
        int[] a4 = { 2, 3, 5 };
        System.out.println(canSumSolver(8, a4, new HashMap<Integer, Boolean>()));
        int[] a5 = { 7, 14 };
        System.out.println(canSumSolver(300, a5, new HashMap<Integer, Boolean>()));
    }
}
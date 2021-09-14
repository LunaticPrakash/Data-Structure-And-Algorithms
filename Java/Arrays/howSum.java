import java.util.ArrayList;
import java.util.HashMap;

public class howSum {
    public static ArrayList<Integer> howSumSolver(int targetSum, int[] nums,
            HashMap<Integer, ArrayList<Integer>> memo) {

        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        for (int n : nums) {
            int rem = targetSum - n;
            ArrayList<Integer> remResult = howSumSolver(rem, nums, memo);
            if (remResult != null) {
                remResult.add(n);
                memo.put(targetSum, remResult);
                return remResult;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {
        int[] a1 = { 2, 3 };
        System.out.println(howSumSolver(7, a1, new HashMap<Integer, ArrayList<Integer>>()));
        int[] a2 = { 5, 3, 4, 7 };
        System.out.println(howSumSolver(7, a2, new HashMap<Integer, ArrayList<Integer>>()));
        int[] a3 = { 2, 4 };
        System.out.println(howSumSolver(7, a3, new HashMap<Integer, ArrayList<Integer>>()));
        int[] a4 = { 2, 3, 5 };
        System.out.println(howSumSolver(8, a4, new HashMap<Integer, ArrayList<Integer>>()));
        int[] a5 = { 7, 14 };
        System.out.println(howSumSolver(300, a5, new HashMap<Integer, ArrayList<Integer>>()));
    }
}
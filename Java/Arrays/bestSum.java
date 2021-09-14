import java.util.ArrayList;
import java.util.HashMap;

public class bestSum {
    public static ArrayList<Integer> bestSumSolver(int targetSum, int[] nums,
            HashMap<Integer, ArrayList<Integer>> memo) {

        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        ArrayList<Integer> shortest = new ArrayList<>();
        for (int n : nums) {
            int rem = targetSum - n;
            ArrayList<Integer> remResult = bestSumSolver(rem, nums, memo);
            if (remResult != null) {
                remResult.add(n);
                if (shortest.size() == 0 || shortest.size() > remResult.size()) {
                    shortest.clear();
                    shortest.addAll(remResult);
                    // memo.put(targetSum, shortest);
                    // return shortest;
                }
            }
        }
        memo.put(targetSum, shortest);
        return shortest;
    }

    public static void main(String[] args) {

        int[] a2 = { 5, 3, 4, 7 };
        System.out.println(bestSumSolver(7, a2, new HashMap<Integer, ArrayList<Integer>>()));
        int[] a3 = { 2, 4 };
        System.out.println(bestSumSolver(7, a3, new HashMap<Integer, ArrayList<Integer>>()));
        int[] a4 = { 2, 3, 5 };
        System.out.println(bestSumSolver(9, a4, new HashMap<Integer, ArrayList<Integer>>()));
        int[] a5 = { 7, 14 };
        System.out.println(bestSumSolver(300, a5, new HashMap<Integer, ArrayList<Integer>>()));
    }
}
import java.util.ArrayList;
import java.util.List;

public class _8_CombinationSum {

    // Get all unique combination whose sum Equals target: Recursion - Time:O(2^N)
    // Space: O(N){for Recursion}
    // The same number may be chosen from candidates an unlimited number of times.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public void combinationSumHelper(int[] candidates, int target, int idx, List<Integer> temp,
            List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || idx >= candidates.length)
            return;

        temp.add(candidates[idx]);
        combinationSumHelper(candidates, target - candidates[idx], idx, temp, res);

        temp.remove(temp.size() - 1);
        combinationSumHelper(candidates, target, idx + 1, temp, res);
    }

    public static void main(String[] args) {

    }
}

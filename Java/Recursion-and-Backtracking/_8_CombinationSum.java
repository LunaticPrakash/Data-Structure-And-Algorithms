import java.util.ArrayList;
import java.util.List;

public class _8_CombinationSum {

    // Get all unique combination whose sum Equals target: Recursion - Time:O(2^N)
    // Space: O(N){for Recursion}
    // The same number may be chosen from candidates an unlimited number of times.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combinationSumHelper(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public void combinationSumHelper(int[] nums, int k, int idx, int sum, List<Integer> temp,
            List<List<Integer>> res) {
        if (k == sum) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (k < sum || idx >= nums.length) {
            return;
        }

        temp.add(nums[idx]);
        sum += nums[idx];
        combinationSumHelper(nums, k, idx, sum, temp, res);

        temp.remove(temp.size() - 1);
        sum -= nums[idx];
        combinationSumHelper(nums, k, idx + 1, sum, temp, res);
    }

    public static void main(String[] args) {

    }
}

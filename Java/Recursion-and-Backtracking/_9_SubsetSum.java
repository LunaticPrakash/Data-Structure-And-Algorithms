import java.util.ArrayList;
import java.util.List;

public class _9_SubsetSum {

    // Sum of all Subsets: Recursion - Time:O(2^N) Space: O(N){for Recursion}
    public static List<Integer> subsetSum(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        subsetSumHelper(nums, 0, 0, res);
        return res;
    }

    private static void subsetSumHelper(int[] nums, int i, int sum, List<Integer> res) {
        if (i == nums.length) {
            res.add(sum);
            return;
        }

        // not pick the element
        subsetSumHelper(nums, i + 1, sum, res);
        
        // pick the element
        subsetSumHelper(nums, i + 1, sum + nums[i], res);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println("Subsets Sum: " + subsetSum(nums));
    }
}

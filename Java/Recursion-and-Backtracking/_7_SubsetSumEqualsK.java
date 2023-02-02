import java.util.ArrayList;
import java.util.List;

public class _7_SubsetSumEqualsK {

    // Check if any Subset sum Equals K: Recursion - Time:O(2^N) Space: O(N){for
    // Recursion}
    public static boolean isSubsetSumPossible(int nums[], int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (nums[n - 1] > sum)
            return isSubsetSumPossible(nums, n - 1, sum);
        return isSubsetSumPossible(nums, n - 1, sum) || isSubsetSumPossible(nums, n - 1, sum - nums[n - 1]);
    }

    // Check if any Subset sum Equals K: Recursion - Time:O(2^N) Space: O(N){for
    // Recursion}
    public static List<List<Integer>> getSubsetsWhoseSumEqualK(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getSubsetsWhoseSumEqualKHelper(nums, k, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private static void getSubsetsWhoseSumEqualKHelper(int[] nums, int k, int idx, int sum, List<Integer> temp,
            List<List<Integer>> res) {
        if (idx == nums.length) {
            if (k == sum)
                res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        sum += nums[idx];
        getSubsetsWhoseSumEqualKHelper(nums, k, idx + 1, sum, temp, res);

        temp.remove(temp.size() - 1);
        sum -= nums[idx];
        getSubsetsWhoseSumEqualKHelper(nums, k, idx + 1, sum, temp, res);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 7;

        System.out.println("Is Subset Possible: " + isSubsetSumPossible(nums, nums.length, k));
        List<List<Integer>> res = getSubsetsWhoseSumEqualK(nums, k);
        System.out.print("Possible Subsets are: ");
        res.stream().forEach(a -> System.out.print(a.toString() + " "));
    }
}

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
        return isSubsetSumPossible(nums, n - 1, sum) || isSubsetSumPossible(nums, n - 1, sum - nums[n - 1]);
    }

    // Get all no. of Subsets whose sum Equals K: Recursion - Time:O(2^N) Space:
    // O(N){for Recursion}
    public static int getNumSubsetSumEqualsK(int[] nums, int k, int n) {
        if (k == 0)
            return 1;
        if (n == 0)
            return 0;

        int e = getNumSubsetSumEqualsK(nums, k, n - 1);
        int i = getNumSubsetSumEqualsK(nums, k - nums[n - 1], n - 1);

        return e + i;
    }

    // Get all Subsets whose sum Equals K: Recursion - Time:O(2^N) Space: O(N){for
    // Recursion}
    public static List<List<Integer>> getSubsetsWhoseSumEqualK(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getSubsetsWhoseSumEqualKHelper(nums, k, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private static void getSubsetsWhoseSumEqualKHelper(int[] nums, int k, int idx, int sum, List<Integer> temp,
            List<List<Integer>> res) {
        if (k == sum){
            res.add(new ArrayList<>(temp));
            return;
        }
        if (idx >= nums.length) {   
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
        int k = 17;

        System.out.println("Is Subset Possible: " + isSubsetSumPossible(nums, nums.length, k));
        System.out.println("Number of Possible Subsets are: " + getNumSubsetSumEqualsK(nums, k, nums.length));
        List<List<Integer>> res = getSubsetsWhoseSumEqualK(nums, k);
        System.out.print("Possible Subsets are: ");
        res.stream().forEach(a -> System.out.print(a.toString() + " "));
    }
}

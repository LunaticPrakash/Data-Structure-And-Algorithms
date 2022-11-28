import java.util.HashMap;

public class _19TwoSum {

    // Approach - 1 Time: O(N2) Space: O(1)
    public static int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    // Approach - 2 Time: O(N) Space: O(N)
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (seen.containsKey(rem)) {
                res[0] = seen.get(rem);
                res[1] = i;
            }
            seen.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int[] result = twoSum2(nums, 9);

        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }
}

import java.util.Arrays;

public class _21LongestConsecutive {

    // Approach - 1 Time: O(NLogN) Space: O(1)
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
            } else if (nums[i - 1] != nums[i]) {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive1(nums));
    }
}

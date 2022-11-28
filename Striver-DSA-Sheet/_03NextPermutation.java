public class _03NextPermutation {

    // Time: O(3N) Space: O(1)
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int p = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                p = i - 1;
                break;
            }
        }

        if (p < 0)
            reverse(nums, p + 1, n - 1);
        else {
            int max = 99;
            int maxIdx = -1;
            for (int i = p + 1; i < n; i++) {
                if (nums[i] > nums[p] && nums[i] <= max) {
                    max = nums[i];
                    maxIdx = i;
                }
            }
            swap(nums, p, maxIdx);
            reverse(nums, p + 1, n - 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 3, 3 };
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
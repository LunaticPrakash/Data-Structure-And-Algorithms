public class _05Sort012Array {

    // Approach - 1 Time: O(N) Space: O(1)
    public static void sortColors(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap(nums, lo, mid);
                lo++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, hi);
                hi--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 1, 0 };
        sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}

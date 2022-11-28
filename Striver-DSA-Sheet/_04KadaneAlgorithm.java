public class _04KadaneAlgorithm { 

    // Approach - 1 Time: O(N3) Space: O(1)
    public static int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += nums[k];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    // Approach - 2 Time: O(N2) Space: O(1)
    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSum = nums[i];
            maxSum = Math.max(maxSum, currSum);

            for (int j = i + 1; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    // Approach - 3 Time: O(N) Space: O(1)
    public static int maxSubArray3(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray1(nums));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));
    }
}

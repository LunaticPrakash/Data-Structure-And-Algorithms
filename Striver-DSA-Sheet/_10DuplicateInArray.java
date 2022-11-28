import java.util.Arrays;

public class _10DuplicateInArray {

    // Approach - 1 Time: O(NLogN) Space: O(1)
    public static int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        return -1;
    }

    // Approach - 2 Time: O(N) Space: O(N)
    public static int findDuplicate2(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i] - 1] != -1)
                return nums[i];
            arr[nums[i] - 1] = nums[i];
        }
        return -1;
    }

    // Approach - 3 Time: O(N) Space: O(1)
    public static int findDuplicate3(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 4 };
        System.out.println(findDuplicate3(nums));
    }
}

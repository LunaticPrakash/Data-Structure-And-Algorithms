import java.util.HashMap;
import java.util.Map;

public class _15MajorityElementsI {

    // Approach - 1 Time: O(N) Space: O(N)
    public static int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
            if (m.getValue() > (nums.length / 2))
                return m.getKey();
        }
        return -1;
    }

    // Approach - 2 Time: O(N) Space: O(1)
    public static int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                candidate = nums[i];
            if (nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement2(nums));
    }
}

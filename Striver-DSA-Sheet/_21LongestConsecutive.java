import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    // Approach - 2 Time: O(N) Space: O(N)
    public static int longestConsecutive2(int[] nums) {
        if(nums.length == 0)
            return 0;
            
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        int longestStreak = 1;
        for(int n : nums){
            if(!set.contains(n-1)){
                int currNum = n;
                int currStreak = 1;

                while(set.contains(currNum+1)){
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive1(nums));
    }
}

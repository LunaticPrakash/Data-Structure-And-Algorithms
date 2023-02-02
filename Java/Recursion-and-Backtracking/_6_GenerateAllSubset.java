import java.util.ArrayList;
import java.util.List;

public class _6_GenerateAllSubset {

    // All Subsets: Recursion - Time:O(2^N) Space: O(N){for Recursion}
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        subsetsHelper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void subsetsHelper(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        if(idx == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        subsetsHelper(nums, idx+1, temp, res);

        temp.remove(temp.size()-1);
        subsetsHelper(nums, idx+1, temp, res);
    }
    public static void main(String[] args) {
        
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_GenerateAllUniqueSubset {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        subsetsHelper(nums, 0, temp, res);
        return res;
    }

    private static void subsetsHelper(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            subsetsHelper(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}

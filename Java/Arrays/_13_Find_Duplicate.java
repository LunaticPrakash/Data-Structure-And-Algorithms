import java.util.Arrays;
import java.lang.Math;

public class _13_Find_Duplicate {
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }

    public void findDuplicate2(int[] nums) {
        int n = nums.length;
        int count[] = new int[Arrays.stream(nums).max().getAsInt() + 1];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            if (count[nums[i]] > 0)
                System.out.print(nums[i] + " ");
            else
                count[nums[i]]++;
        }
    }

    public void findDuplicate3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) % n;
            if (nums[idx] > 0)
                nums[idx] *= -1;
            else
                System.out.print(idx + " ");
        }
    }

    public void findDuplicate4(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = nums[i] % n;
            nums[idx] += n;
        }
        for(int i=0;i<n;i++){
            if(nums[i] >= n*2){
                System.out.println(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        _13_Find_Duplicate obj = new _13_Find_Duplicate();
        int arr[] = { 8, 3, 4, 2, 2 };
        // int result = obj.findDuplicate1(arr);
        // System.out.println(result);
        obj.findDuplicate3(arr);
    }
}

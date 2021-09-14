import java.util.Scanner;

public class _16_Next_Permutation {

    private void getNextPerm(int[] nums) {

        int n = nums.length;
        int p = -1;
        // 4 3 5 6 9 8 7 , p = 6
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                p = i - 1;
                break;
            }
        }

        if (p == -1) {
            System.out.println("\nNext Permutation not possible!");
            reverse(nums, 0, n - 1);
            return;
        }

        // 4 3 5 6 9 8 7 , p = 3, i = 4
        int idx = -1;
        for (int i = p + 1; i < n; i++) {
            if (nums[i] > nums[p]) {
                if(idx == -1){
                    idx = i;
                }
                else if (nums[idx] >= nums[i]) {
                    idx = i;
                }
            }
        }

        // 4 3 5 6 9 8 7 , p = 3, idx = 6
        swap(nums, p, idx);
        // 4 3 5 7 9 8 6 , p = 3, idx = 6
        reverse(nums, p + 1, n - 1);
        // 4 3 5 7 6 8 9 , p = 3, idx = 6

        System.out.print("Next Permutation = ");
        for (int i : nums)
            System.out.print(i + " ");

    }

    private void reverse(int[] nums, int start, int end) {
        if (start < end) {
            swap(nums, start, end);
            reverse(nums, start + 1, end - 1);
        }
    }

    private void swap(int[] nums, int p, int idx) {
        int temp = nums[p];
        nums[p] = nums[idx];
        nums[idx] = temp;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your array elements :- ");
        String numbers[] = scan.nextLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(numbers[i]);
        }

        _16_Next_Permutation obj = new _16_Next_Permutation();
        obj.getNextPerm(arr);
        scan.close();
    }
}

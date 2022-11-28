import java.util.Arrays;

public class _9MergeSortedArray {
    // Approach - 1 Time: O(NLogN) + O(M) + O(N) + O(N+M) Space: O(N+M)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            res[k] = nums1[i];
            k++;
        }
        for (int i = 0; i < n; i++) {
            res[k] = nums2[i];
            k++;
        }
        Arrays.sort(res);

        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    // Approach - 2 Time: O(N) Space: O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;

                int key = nums2[j];
                int tempj = j;

                while (tempj < n - 1 && nums2[tempj] < key) {
                    nums2[tempj] = nums2[tempj + 1];
                    tempj++;
                }
                nums2[tempj] = key;
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        merge2(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++)
            System.out.print(nums1[i] + " ");
    }
}

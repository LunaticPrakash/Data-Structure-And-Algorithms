public class _13SearchIn2dMatrix {

    // Approach - 1 Time: O(N + LogN) Space: O(1)
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int row = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target)
                row = i;
        }
        if (row == -1)
            return false;
        return binarySearch(matrix[row], 0, matrix[row].length - 1, target);
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    // Approach - 2 Time: O(LogN) Space: O(1)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (matrix[mid / col][mid % col] == target)
                return true;
            else if (matrix[mid / col][mid % col] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1 } };
        System.out.println(searchMatrix2(matrix, 0));
    }
}

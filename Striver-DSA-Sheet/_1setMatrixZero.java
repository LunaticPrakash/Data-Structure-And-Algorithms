public class _1setMatrixZero {

    // Approach - 1 Time: O(N2) Space: O(2N)
    public static void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Helper arrays which will store index
        // of rows and columns which have to
        // be 0
        boolean[] isRow0 = new boolean[row];
        boolean[] isCol0 = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    isRow0[i] = true;
                    isCol0[j] = true;
                }
            }
        }

        // setting matrix[i][j] = 0 based on
        // the helper arrays.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isRow0[i] || isCol0[j])
                    matrix[i][j] = 0;
            }
        }
    }

    // Approach - 2 Time: O(N2) Space: O(1)
    public static void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean isCol0 = false; // to check if 0th col should be 0

        // using 0th row & column as helper arrays
        for (int i = 0; i < row; i++) {
            // first check if 0th col should be 0
            // or not, because after manipulation
            // 0th column values might change, and will
            // give you false picture of the situation
            if (matrix[i][0] == 0)
                isCol0 = true;

            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (isCol0)
                matrix[i][0] = 0;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeroes2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
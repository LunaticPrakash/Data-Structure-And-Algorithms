package Arrays;

import java.util.List;
import java.util.ArrayList;

public class spiralMatrix {

    public static List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int row = matrix.length, col = matrix[0].length;
        int up = 0, down = row - 1, left = 0, right = col - 1;

        while (result.size() < row * col) {
            // Left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }

            // top to down
            for (int i = up+1; i <= down; i++) {
                result.add(matrix[i][right]);
            }

            // right to left
            if (up != down) {
                for (int i = right-1; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }

            // down to top
            if (left != right) {
                for (int i = down-1; i > up; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            up++;
            right--;
            down--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        // 1   2   3   4
        // 5   6   7   8
        // 9   10  11 12
        System.out.println(spiral(matrix));
    }
}

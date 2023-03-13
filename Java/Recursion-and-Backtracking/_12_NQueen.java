import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _12_NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        char[][] board = new char[n][n];

        Arrays.stream(board).forEach(a -> Arrays.fill(a, '.'));
        solve(board, 0, ans);
        return ans;
    }

    public void solve(char[][] board, int col, List<List<String>> ans) {
        if (col == board[0].length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, col + 1, ans);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;

        while (row >= 0 && col >= 0)
            if (board[row--][col--] == 'Q')
                return false;

        row = dupRow;
        col = dupCol;
        while (col >= 0)
            if (board[row][col--] == 'Q')
                return false;

        row = dupRow;
        col = dupCol;
        while (row < board.length && col >= 0)
            if (board[row++][col--] == 'Q')
                return false;

        return true;
    }

    public static void main(String[] args) {

    }
}
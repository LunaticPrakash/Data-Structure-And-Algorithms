package Graph;

public class NumOfIslands {

    public static void dfs(int i, int j, int[][] visited, char[][] grid, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0')
            return;
        if (visited[i][j] == 0) {
            visited[i][j] = 1;
            dfs(i - 1, j, visited, grid, row, col);
            dfs(i - 1, j + 1, visited, grid, row, col);
            dfs(i, j + 1, visited, grid, row, col);
            dfs(i + 1, j + 1, visited, grid, row, col);
            dfs(i + 1, j, visited, grid, row, col);
            dfs(i + 1, j - 1, visited, grid, row, col);
            dfs(i, j - 1, visited, grid, row, col);
            dfs(i - 1, j - 1, visited, grid, row, col);
        }
    }

    public static int numOfIsland(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int[][] visited = new int[501][501];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] != 1 && grid[i][j] == '1') {
                    dfs(i, j, visited, grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }

}

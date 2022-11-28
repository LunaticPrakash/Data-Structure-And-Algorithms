import java.util.Arrays;

public class _17GridUniquePath {

    // Approach - 1 Time: O(2^N) Space: O(2^N)
    public static int uniquePaths1(int m, int n) {
        return solve(m, n, 0, 0);
    }

    private static int solve(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i >= m || i < 0 || j >= n || j < 0)
            return 0;
        return solve(m, n, i + 1, j) + solve(m, n, i, j + 1);
    }

    // Approach - 2 Time: O(M*N) Space: O(M*N)
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return solve(m, n, 0, 0, dp);
    }

    private static int solve(int m, int n, int i, int j, int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return 1;
        else if (i >= m || i < 0 || j >= n || j < 0)
            return 0;
        else if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = solve(m, n, i + 1, j, dp) + solve(m, n, i, j + 1, dp);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 7));
    }
}

import java.util.Arrays;

public class Knapsack {

    // Simple Recursion
    public static int Knapsack01(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0)
            return 0;
        else if (wt[n - 1] <= W)
            return Math.max(val[n - 1] + Knapsack01(wt, val, W - wt[n - 1], n - 1), Knapsack01(wt, val, W, n - 1));
        return Knapsack01(wt, val, W, n - 1);
    }

    // Memoized Solution
    public static int Knapsack01Mem(int[] wt, int[] val, int W, int n, int[][] dp) {
        if (n == 0 || W == 0)
            return 0;
        else if (dp[n][W] != -1)
            return dp[n][W];
        else if (wt[n - 1] <= W)
            return dp[n][W] = Math.max(val[n - 1] + Knapsack01Mem(wt, val, W - wt[n - 1], n - 1, dp), Knapsack01Mem(wt, val, W, n - 1, dp));
        return dp[n][W] = Knapsack01Mem(wt, val, W, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] val = { 60, 100, 120, 140, 160 };
        int[] wt = { 10, 20, 30, 50, 60 };
        int W = 70;
        int n = val.length;

        System.out.println("Max Profit = " + Knapsack01(wt, val, W, n));

        int[][] dp = new int[n + 1][W + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        System.out.println("Max Profit = " + Knapsack01Mem(wt, val, W, n, dp));
    }
}
import java.util.Scanner;

public class _26_Max_Profit_Stock_atmost_2_transaction {

    private static int getMaxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        int ma = prices[n - 1];
        int mi = prices[0];

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < mi)
                mi = prices[i];
            dp[i] = Math.max(dp[i - 1], prices[i] - mi);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > ma)
                ma = prices[i];
            dp[i] = Math.max(dp[i + 1], dp[i] + (ma - prices[i]));
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your array elements :- ");
        String numbers[] = scan.nextLine().split(" ");
        scan.close();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(numbers[i]);
        }
        getMaxProfit(arr);
    }
}

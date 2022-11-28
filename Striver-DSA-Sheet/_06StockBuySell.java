public class _06StockBuySell {

    // Approach - 1 Time: O(N2) Space: O(1)
    public static int maxProfit1(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // Approach - 2 Time: O(N) Space: O(1)
    public static int maxProfit2(int[] prices) {
        int cp = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < cp)
                cp = prices[i];
            else {
                max = Math.max(max, prices[i] - cp);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit2(prices));
    }
}

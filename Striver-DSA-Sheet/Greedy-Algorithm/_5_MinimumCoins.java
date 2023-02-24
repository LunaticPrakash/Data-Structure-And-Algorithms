import java.util.ArrayList;
import java.util.List;

public class _5_MinimumCoins {
    public static int minCoins(int coins[], int V) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            while (V >= coins[i]) {
                V -= coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println(ans.toString());
        return ans.size();
    }

    public static void main(String[] args) {
        int coins[] = { 9, 6, 5, 1 };
        int V = 11;

        System.out.println("Minimum Coins: " + minCoins(coins, V));
    }
}
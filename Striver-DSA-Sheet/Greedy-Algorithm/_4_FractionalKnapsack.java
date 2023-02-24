import java.util.Arrays;

class Item {
    public int weight;
    public int value;

    Item() {
    }

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public String toString() {
        return "weight: " + this.weight + " value: " + this.value;
    }
}

public class _4_FractionalKnapsack {

    public static double solve(int[] weight, int[] value, int W) {
        Item[] items = new Item[weight.length];
        for (int i = 0; i < weight.length; i++) {
            items[i] = new Item(weight[i], value[i]);
        }

        Arrays.sort(items, (i1, i2) -> (i2.value / i2.weight) - (i1.value / i1.weight));

        System.out.println(Arrays.toString(items));
        double maxProfit = 0;

        for (Item i : items) {
            if (i.weight <= W) {
                maxProfit += i.value;
                W -= i.weight;
            } else {
                double fractionWeight = (double) W / (double) i.weight;
                double fractionProfit = i.value * fractionWeight;
                maxProfit += fractionProfit;
                W -= fractionWeight;
                break;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };

        System.out.println("Max Profit : " + solve(weight, value, 50));
    }
}

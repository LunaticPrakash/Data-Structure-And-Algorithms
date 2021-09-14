package Arrays;

import java.util.Scanner;

public class _18_Best_Time_To_Buy_Sell {

    private int getMaxProfit(int arr[]) {
        int n = arr.length;
        int maxProfit = Integer.MIN_VALUE;
        int currCostPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < currCostPrice)
                currCostPrice = arr[i];
            else if ((arr[i] - currCostPrice) > maxProfit)
                maxProfit = arr[i] - currCostPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your array elements :- ");
        String numbers[] = scan.nextLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(numbers[i]);
        }

        _18_Best_Time_To_Buy_Sell obj = new _18_Best_Time_To_Buy_Sell();
        long result = obj.getMaxProfit(arr);
        System.out.println("Max Profit = " + result);
    }
}

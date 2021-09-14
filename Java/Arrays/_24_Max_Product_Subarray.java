package Arrays;

import java.util.Scanner;

public class _24_Max_Product_Subarray {

    private long getMaxProd1(int[] arr, int n) {
        long maxProd = arr[0];
        for (int i = 0; i < n; i++) {
            long currProd = arr[i];
            for (int j = i + 1; j < n; j++) {
                // currProd *= arr[j];
                // if (currProd > maxProd)
                //     maxProd = currProd;
                maxProd = Math.max(maxProd, Math.max(currProd, currProd*arr[j]));
                currProd *= arr[j];
            }
            if (currProd > maxProd)
                maxProd = currProd;
        }
        return maxProd;
    }

    private long getMaxProd2(int[] arr, int n) {
        long maxProdTilli = arr[0];
        long minProdTilli = arr[0];
        long result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {

            if (arr[i] < 0) {
                long temp = maxProdTilli;
                maxProdTilli = minProdTilli;
                minProdTilli = temp;
            }

            maxProdTilli = Math.max(arr[i], maxProdTilli * arr[i]);
            minProdTilli = Math.min(arr[i], minProdTilli * arr[i]);
            result = Math.max(maxProdTilli, result);
        }
        return result;
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

        _24_Max_Product_Subarray obj = new _24_Max_Product_Subarray();
        System.out.println("Max Product = " + obj.getMaxProd1(arr, n));
    }
}

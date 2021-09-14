package Search_And_Sort;

import java.util.ArrayList;
import java.util.Scanner;

public class _16_Min_Swaps_to_Sort {

    private static void display(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static int getCount(int[] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(arr[i]);
            list.add(i, row);
        }
        int swap = 0;
        display(list);
        return swap;
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

        getCount(arr);
    }
}

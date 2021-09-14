package Search_And_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class _6_Find_Missing_And_Repeating {

    private static int[] getMissingRepeating(int[] arr, int n) {
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index-1] > 0) {
                arr[index-1] = -arr[index-1];
            } else
                result[1] = index;
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] > 0)
            result[0] = i+1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter length of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        int arr[] = new int[n];
        System.out.println("Enter array element :- ");
        String line[] = scan.nextLine().split("\\s+");
        for (int i = 0; i < line.length; i++)
            arr[i] = Integer.parseInt(line[i]);

        int[] result = getMissingRepeating(arr, n);
        System.out.println("Missing = " + result[0]);
        System.out.println("Repeating = " + result[1]);
    }
}

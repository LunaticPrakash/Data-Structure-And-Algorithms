import java.util.Arrays;
import java.util.Scanner;

public class _30_Find_the_Median {

    private static int getMedian(int arr[], int n) {

        Arrays.sort(arr);
        int median = 0;
        if (n % 2 == 0) { // even
            int n1 = arr[n / 2 - 1];
            int n2 = arr[n / 2];
            median = (n1 + n2) / 2;

        } else { // odd
            median = arr[n / 2];
        }
        return median;
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
        scan.close();
        System.out.println("Median = " + getMedian(arr, n));
    }
}

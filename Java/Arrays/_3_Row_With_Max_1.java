import java.util.Scanner;

public class _3_Row_With_Max_1 {

    // private static int getRow(int arr[][], int n, int m) {
    //     int maxCount1 = 0;
    //     int maxCountRow = -1;
    //     for (int i = 0; i < n; i++) {
    //         int count = 0;
    //         for (int j = 0; j < m; j++) {
    //             if (arr[i][j] == 1) {
    //                 count += 1;
    //                 if (count > maxCount1) {
    //                     maxCount1 = count;
    //                     maxCountRow = i;
    //                 }
    //             }
    //         }
    //     }
    //     return maxCountRow;
    // }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    private static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int maxSum = 0;
        int maxCountRow = -1;
        for (int i = 0; i < n; i++) {
            int sum = getSum(arr[i]);
            if (sum > maxSum) {
                maxSum = sum;
                maxCountRow = i;
            }
        }
        return maxCountRow;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr[][] = new int[1000][1000];
        System.out.print("Enter number of rows : ");
        int r = scan.nextInt();
        System.out.print("Enter number of columns : ");
        int c = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter array element :- ");
        for (int i = 0; i < c; i++) {
            String line[] = scan.nextLine().split(" ");
            for (int j = 0; j < c; j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }
        System.out.println("Row with max 1 = " + rowWithMax1s(arr, r, c));
        scan.close();
    }
}

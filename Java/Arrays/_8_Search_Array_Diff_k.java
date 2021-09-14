import java.util.Scanner;

public class _8_Search_Array_Diff_k {

    private static int find(int[] arr, int diff, int key) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == key)
                return i;
            i = Math.max(1, Math.abs(arr[i] - key) / diff);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter length of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter difference : ");
        int diff = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter key to search : ");
        int key = scan.nextInt();
        scan.nextLine();
        int arr[] = new int[n];
        System.out.println("Enter array element :- ");
        String line[] = scan.nextLine().split("\\s+");
        for (int i = 0; i < line.length; i++)
            arr[i] = Integer.parseInt(line[i]);
        System.out.println("Index = " + find(arr, diff, key));
        scan.close();
    }
}
import java.util.Scanner;

public class _17_Count_Inversions {
    private long getInversion(int arr[]) {

        int n = arr.length;
        int count_inv = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    count_inv += 1;
            }
        }
        return count_inv;
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

        _17_Count_Inversions obj = new _17_Count_Inversions();
        long result = obj.getInversion(arr);
        System.out.println("\nInversion Count = " + result);
        scan.close();
    }
}

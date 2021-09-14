package Arrays;

import java.util.Scanner;

public class _21_Rearrange_Alternate_Positive_Negative {

    private void rearrange(int[] arr, int n) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                int temp = arr[c];
                arr[c] = arr[i];
                arr[i] = temp;
                c++;
            }
        }

        int lastIdx = n-1;
        for (int i = 1; i < n; i+=2) {
            if(arr[i] >= 0){
                int temp = arr[i];
                arr[i] = arr[lastIdx];
                arr[lastIdx] = temp;
                lastIdx--;
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
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
        scan.close();

        _21_Rearrange_Alternate_Positive_Negative obj = new _21_Rearrange_Alternate_Positive_Negative();
        obj.rearrange(arr, n);
    }

}

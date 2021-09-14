import java.util.Scanner;

public class _9_Rotate_Array_By_One {

    public void rotateByOne(int arr[], int n) {
        int temp = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = temp;
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

        _9_Rotate_Array_By_One obj = new _9_Rotate_Array_By_One();
        obj.rotateByOne(arr, n);

        for (int i : arr)
            System.out.print(i + " ");
        scan.close();
    }
}

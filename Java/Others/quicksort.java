import java.util.Arrays;
import java.util.Comparator;

public class quicksort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int i, int j) {
        int pivot = i;
        int n = arr.length;

        while (i < j) {
            while (i < n && arr[i] <= arr[pivot])
                i++;
            while (j >= 0 && arr[j] > arr[pivot])
                j--;

            if (i < j)
                swap(arr, i, j);
        }

        swap(arr, pivot, j);
        return j;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { -2, -4 }, { 0, 0 }, { 4, 5 } };
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        // quickSort(arr, 0, 7);
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < 2; j++)
                System.out.print(arr[i][j] + " ");

    }
}

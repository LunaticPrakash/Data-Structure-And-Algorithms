import java.util.Arrays;

public class mergesort {

    public static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1; // [0,mid] size of left array   +1 because  mid is included
        int n2 = r - mid; // [mid+1,r] size of right array

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];

        for (int i = 0; i < n2; i++)
            right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, -2, -4, 0, 0, 4, 5 };
        mergeSort(arr, 0, 7);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
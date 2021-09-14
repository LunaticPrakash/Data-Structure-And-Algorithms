import java.util.Scanner;

public class _31_Median_of_2_Sorted_Array_Same_Size {

    private static int getMedian(int[] a, int[] b, int startA, int startB, int endA, int endB) {
        if (endA - startA == 1) {
            return (Math.max(a[startA], b[startB]) + Math.min(a[endA], b[endB])) / 2;
        }

        int m1 = median(a, startA, endA);
        int m2 = median(b, startB, endB);

        if (m1 == m2)
            return m1;

        else if (m1 > m2) {
            return getMedian(a, b, startA, (startB + endB + 1) / 2, (startA + endA + 1) / 2, endB);
        }

        else {
            return getMedian(a, b, (startA + endA + 1) / 2, startB, endA, (startB + endB + 1) / 2);
        }
    }

    private static int median(int[] arr, int start, int end) {
        int median = 0;
        int n = end - start + 1;
        if (n % 2 == 0) { // even
            int n1 = arr[start + (n - 1) / 2];
            int n2 = arr[start + n / 2];
            median = (n1 + n2) / 2;

        } else { // odd
            median = arr[n / 2];
        }
        return median;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of 1st array : ");
        int n1 = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your 1st array element :- ");
        String numbers[] = scan.nextLine().split(" ");
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.valueOf(numbers[i]);
        }

        System.out.print("\nEnter size of 2nd array : ");
        int n2 = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your 2nd array element :- ");
        numbers = scan.nextLine().split(" ");
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.valueOf(numbers[i]);
        }
        scan.close();

        System.out.println(getMedian(arr1, arr2, 0, 0, n1, n2));
    }
}

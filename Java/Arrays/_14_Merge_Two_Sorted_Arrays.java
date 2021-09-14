package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _14_Merge_Two_Sorted_Arrays {

    // Time -> O((n+m)log(n+m)), Space -> O(n+m)
    private void mergeArrays1(int a1[], int a2[]) {
        int n1 = a1.length;
        int n2 = a2.length;
        int merge[] = new int[n1 + n2];

        int c = 0;
        for (int i = 0; i < n1; i++) {
            merge[c] = a1[i];
            c++;
        }

        for (int i = 0; i < n2; i++) {
            merge[c] = a2[i];
            c++;
        }

        Arrays.sort(merge);

        for (int i = 0; i < n1; i++)
            a1[i] = merge[i];

        for (int i = 0; i < n2; i++)
            a2[i] = merge[n1 + i];

        for (int i = 0; i < n1; i++)
            System.out.print(a1[i] + " ");

        for (int i = 0; i < n1; i++)
            System.out.print(a2[i] + " ");
    }

    // Time -> O(n*m), Space -> O(1)
    private void mergeArrays2(int a1[], int a2[]) {
        int n1 = a1.length;
        int n2 = a2.length;

        for (int i = 0; i < n1; i++) {
            if (a1[i] > a2[0]) {
                int temp = a1[i];
                a1[i] = a2[0];
                a2[0] = temp;

                int j = 0;
                while (j < n2 && a2[j] > a2[j + 1]) {
                    temp = a2[j];
                    a2[j] = a2[j + 1];
                    a2[j + 1] = temp;
                    j++;
                }
            }
        }

        for (int i = 0; i < n1; i++)
            System.out.print(a1[i] + " ");

        for (int i = 0; i < n2; i++)
            System.out.print(a2[i] + " ");

        // System.out.println("\nAfter Sorting :- ");
        // System.out.print("First Array :- ");
        // for (int i : a1) {
        // System.out.print(i + " ");
        // }

        // System.out.print("\nSecond Array :- ");
        // for (int i : a2) {
        // System.out.print(i + " ");
        // }
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

        _14_Merge_Two_Sorted_Arrays obj = new _14_Merge_Two_Sorted_Arrays();
        // int result[] = obj.mergeArrays1(arr1, arr2);
        // System.out.print("\nSorted Merged Array :- ");
        // for (int i : result) {
        // System.out.print(i + " ");
        // }
        obj.mergeArrays1(arr1, arr2);
    }
}

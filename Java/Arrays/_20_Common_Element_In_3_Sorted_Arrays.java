package Arrays;

import java.util.*;

public class _20_Common_Element_In_3_Sorted_Arrays {

    private ArrayList<Integer> getCommonElement1(int A[], int B[], int C[], int n1, int n2, int n3) {

        ArrayList<Integer> common = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n3; k++) {
                    if (A[i] == B[j] && B[j] == C[k]) {
                        if (!common.contains(A[i]))
                            common.add(A[i]);
                    }
                }
            }
        }
        for (int i = 0; i < common.size(); i++) {
            System.out.print(common.get(i) + " ");
        }
        return common;
    }

    private ArrayList<Integer> getCommonElement2(int A[], int B[], int C[], int n1, int n2, int n3) {

        ArrayList<Integer> common = new ArrayList<>();
        int p = 0;
        int q = 0;
        int r = 0;

        while (p < n1 && q < n2 && r < n3) {

            if (A[p] == B[q] && B[q] == C[r]) {
                if (!common.contains(A[p]))
                    common.add(A[p]);
                p++;
                q++;
                r++;
            } else {
                if (A[p] > B[q]) {
                    q++;
                }

                if (A[p] > C[r]) {
                    r++;
                }

                if (q < n2 && r < n3) {
                    if (A[p] < B[q] || A[p] < C[r]) {
                        p++;
                    }
                }
            }
        }
        for (int i = 0; i < common.size(); i++) {
            System.out.print(common.get(i) + " ");
        }
        return common;
    }

    public static void main(String[] args) {

        // Scanner scan = new Scanner(System.in);
        // System.out.print("Enter size of 1st array : ");
        // int n1 = scan.nextInt();
        // scan.nextLine();
        // System.out.print("Enter your 1st array element :- ");
        // String numbers[] = scan.nextLine().split(" ");
        // int arr1[] = new int[n1];
        // for (int i = 0; i < n1; i++) {
        // arr1[i] = Integer.valueOf(numbers[i]);
        // }

        // System.out.print("\nEnter size of 2nd array : ");
        // int n2 = scan.nextInt();
        // scan.nextLine();
        // System.out.print("Enter your 2nd array element :- ");
        // numbers = scan.nextLine().split(" ");
        // int arr2[] = new int[n2];
        // for (int i = 0; i < n2; i++) {
        // arr2[i] = Integer.valueOf(numbers[i]);
        // }

        // System.out.print("\nEnter size of 3rd array : ");
        // int n3 = scan.nextInt();
        // scan.nextLine();
        // System.out.print("Enter your 3rd array element :- ");
        // numbers = scan.nextLine().split(" ");
        // int arr3[] = new int[n3];
        // for (int i = 0; i < n3; i++) {
        // arr3[i] = Integer.valueOf(numbers[i]);
        // }
        // scan.close();

        _20_Common_Element_In_3_Sorted_Arrays obj = new _20_Common_Element_In_3_Sorted_Arrays();
        // obj.getCommonElement1(arr1, arr2, arr3, n1, n2, n3);
        int[] a2 = { 1, 5, 10, 20, 40, 80 };
        int[] a1 = { 6, 7, 20, 80, 100 };
        int[] a3 = { 3, 4, 15, 20, 30, 70, 80, 120 };
        int n2 = 6;
        int n1 = 5;
        int n3 = 8;

        obj.getCommonElement2(a1, a2, a3, n1, n2, n3);

    }
}

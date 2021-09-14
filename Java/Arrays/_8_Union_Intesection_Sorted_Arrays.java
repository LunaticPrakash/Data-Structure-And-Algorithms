import java.util.ArrayList;
import java.util.Scanner;

public class _8_Union_Intesection_Sorted_Arrays {

    public ArrayList<Integer> unionSortedArray(int arr1[], int n1, int arr2[], int n2) {
        ArrayList<Integer> union = new ArrayList<Integer>();
        for (int i = 0; i < n1; i++) {
            union.add(arr1[i]);
        }
        for (int i = 0; i < n2; i++) {
            if (!union.contains(arr2[i]))
                union.add(arr2[i]);
        }
        return union;
    }

    public ArrayList<Integer> intersectionSortedArray(int arr1[], int n1, int arr2[], int n2) {
        ArrayList<Integer> intersec = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] == arr2[j]) {
                intersec.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return intersec;
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

        _8_Union_Intesection_Sorted_Arrays obj = new _8_Union_Intesection_Sorted_Arrays();
        ArrayList<Integer> union = obj.unionSortedArray(arr1, n1, arr2, n2);
        ArrayList<Integer> intersec = obj.intersectionSortedArray(arr1, n1, arr2, n2);

        System.out.print("\nUnion :- ");
        for (int i = 0; i < union.size(); i++) {
            System.out.print(union.get(i) + " ");
        }

        System.out.print("\nIntersection :- ");
        for (int i = 0; i < intersec.size(); i++) {
            System.out.print(intersec.get(i) + " ");
        }
    }

}

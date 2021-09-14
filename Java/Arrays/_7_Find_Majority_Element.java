package Search_And_Sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _7_Find_Majority_Element {

    private static int getMajorityElement(int a[], int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(a[i]))
                map.put(a[i], 1);
            else
                map.put(a[i], map.get(a[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > size / 2)
                return m.getKey();
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr[] = new int[100];
        System.out.print("Enter length of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter array element :- ");
        String line[] = scan.nextLine().split("\\s+");
        for (int i = 0; i < line.length; i++)
            arr[i] = Integer.parseInt(line[i]);

        System.out.println(getMajorityElement(arr, n));
    }

}

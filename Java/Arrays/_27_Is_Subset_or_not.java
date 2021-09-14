package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _27_Is_Subset_or_not {

    private static String isSubset(long a1[], long a2[], long n, long m) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (!map.containsKey(a2[i]))
                map.put(a2[i], 1);
            else
                map.put(a2[i], map.get(a2[i]) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(a1[i]))
                map.put(a1[i], map.get(a1[i]) - 1);
        }

        for (Map.Entry<Long, Integer> a : map.entrySet()) {
            if (a.getValue() > 0)
                return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of 1st array : ");
        long n1 = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your 1st array element :- ");
        String numbers[] = scan.nextLine().split(" ");
        long arr1[] = new long[(int)n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.valueOf(numbers[i]);
        }

        System.out.print("\nEnter size of 2nd array : ");
        long n2 = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your 2nd array element :- ");
        numbers = scan.nextLine().split(" ");
        long arr2[] = new long[(int)n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.valueOf(numbers[i]);
        }

        scan.close();

        System.out.println(isSubset(arr1, arr2, n1, n2));
    }
}

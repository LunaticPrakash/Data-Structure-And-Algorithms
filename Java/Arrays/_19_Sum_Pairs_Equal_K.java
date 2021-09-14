package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _19_Sum_Pairs_Equal_K {

    private void getPairs1(int arr[], int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k)
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }

    }

    private void getPairs2(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int j = k - arr[i]; // k = arr[i] + j
            if (set.contains(j)) {
                count++;
                // System.out.println("(" + arr[i] + ", " + j + ")");
            }
            set.add(arr[i]);
        }
        System.out.println("\nCount = " + count);
    }

    private void getPairs3(int[] arr, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (seen.containsKey(arr[i]))
                seen.put(arr[i], seen.get(arr[i]) + 1);
            else
                seen.put(arr[i], 1);
        }
        for (int i = 0; i < n; i++) {
            int j = k - arr[i];
            if (seen.containsKey(j)) {
                seen.put(arr[i], seen.get(arr[i]) - 1);
                count += seen.get(j);
            }
        }
        System.out.println("Count = " + count);
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
        System.out.print("Enter value of k : ");
        int k = scan.nextInt();

        _19_Sum_Pairs_Equal_K obj = new _19_Sum_Pairs_Equal_K();
        obj.getPairs3(arr, k);

    }

}

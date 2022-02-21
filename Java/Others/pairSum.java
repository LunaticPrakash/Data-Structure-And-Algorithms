import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class pairSum {

    public static ArrayList<ArrayList<Integer>> pairSumSolver1(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k)
                    res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j])));
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> pairSumSolver2(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (seen.contains(k - arr[i]))
                res.add(new ArrayList<>(Arrays.asList(arr[i], k - arr[i])));
            seen.add(arr[i]);
        }
        return res;
    }

    public static int pairSumSolver3(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(k - arr[i])) {
                count += 1;
                map.put((k-arr[i]), map.get(k-arr[i])-1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1 };
        int sum = 2;
        System.out.println("Pairs = " + pairSumSolver3(arr, sum));
    }
}

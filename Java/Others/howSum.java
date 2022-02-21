import java.util.ArrayList;
import java.util.HashMap;

public class howSum {

    public static ArrayList<Integer> howSumSolver(int[] arr, int targetSum) {

        if (targetSum == 0)
            return new ArrayList<>();
        else if (targetSum < 0)
            return null;
        for (int i = 0; i < arr.length; i++) {
            int remainingSum = targetSum - arr[i];
            ArrayList<Integer> t = howSumSolver(arr, remainingSum);
            if (t != null) {
                t.add(arr[i]);
                return t;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int[] arr1 = { 77, 32, 9, 45, 40, 27, 24, 38, 39, 19, 83, 30, 42, 34, 16, 40 };
        int targetSum = 659;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        System.out.println("CanSum = " + howSumSolver(arr, 30));
    }
}

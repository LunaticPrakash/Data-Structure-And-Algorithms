import java.util.ArrayList;

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
        System.out.println("HowSum = " + howSumSolver(arr, 30));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class _15_Merge_Intervals {

    private int[][] mergeIntervals(int intervals[][]) {

        // intervals = [[a,b], [c,d]];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<ArrayList<Integer>> stack = new ArrayList<ArrayList<Integer>>();
        int row = intervals.length;
        stack.add(0, new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));
        int top = 0;

        for (int i = 1; i < row; i++) {
            stack.add(top + 1, new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            top++;
            int b = stack.get(top - 1).get(1);
            int c = stack.get(top).get(0);
            int d = stack.get(top).get(1);

            if (b >= c) {
                if (b >= d) {
                    stack.remove(top);
                    top--;
                } else {
                    stack.remove(top);
                    top--;
                    stack.get(top).set(1, d);
                }
            }
        }
        int result[][] = new int[stack.size()][2];
        for (int i = 0; i < stack.size(); i++) {
            result[i][0] = stack.get(i).get(0);
            result[i][1] = stack.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of intervals : ");
        int row = scan.nextInt();
        scan.nextLine();

        int intervals[][] = new int[row][2];
        System.out.print("\nEnter your array element :- ");
        for (int i = 0; i < row; i++) {
            String interval[] = scan.nextLine().split(" ");
            intervals[i][0] = Integer.valueOf(interval[0]);
            intervals[i][1] = Integer.valueOf(interval[1]);
        }

        _15_Merge_Intervals obj = new _15_Merge_Intervals();
        int result[][] = obj.mergeIntervals(intervals);
        for (int i = 0; i < result.length; i++)
            System.out.print("[" + result[i][0] + " " + result[i][1] + "] ");
        scan.close();
    }

}

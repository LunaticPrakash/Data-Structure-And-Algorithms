import java.util.ArrayList;
import java.util.Arrays;

public class _08MergeIntervals {

    // Time: O(NLogN + N) Space: O(N)
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> i1[0] != i2[0] ? i1[0] - i2[0] : i1[1] - i2[1]);

        ArrayList<ArrayList<Integer>> stack = new ArrayList<ArrayList<Integer>>();
        stack.add(new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));
        int top = 0;

        for (int i = 1; i < intervals.length; i++) {
            int a = stack.get(top).get(0);
            int b = stack.get(top).get(1);
            int c = intervals[i][0];
            int d = intervals[i][1];

            if (b >= c) {
                if (b >= d) {
                    stack.get(top).set(1, b);
                } else {
                    stack.get(top).set(1, d);
                }
            } else {
                stack.add(new ArrayList<>(Arrays.asList(c, d)));
                top++;
            }
        }

        int[][] result = new int[stack.size()][2];
        for (int i = 0; i < stack.size(); i++) {
            result[i][0] = stack.get(i).get(0);
            result[i][1] = stack.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

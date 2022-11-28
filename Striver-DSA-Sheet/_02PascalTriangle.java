import java.util.*;

public class _02PascalTriangle {

    // Time: O(N2) Space: O(N2)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            } 
            pre = row;
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }
}

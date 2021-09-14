package Arrays;

public class containerWithMostWater {

    public static int solve1(int[] heights) {
        int area = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                area = Math.max(area, Math.min(heights[i], heights[j]) * (j - i));
            }
        }
        return area;
    }

    public static int solve2(int[] heights) {
        int n = heights.length;
        int i = 0, j = n - 1;
        int area = 0;
        while (i < j) {
            area = Math.max(area, Math.min(heights[i], heights[j]) * (j - 1));
            if (heights[i] > heights[j])
                j--;
            else
                i++;
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(solve1(heights));
        System.out.println(solve2(heights));
    }

}

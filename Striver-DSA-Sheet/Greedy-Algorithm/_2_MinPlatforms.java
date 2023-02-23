import java.util.Arrays;

public class _2_MinPlatforms {

    public static int minPlatforms(int[] st, int[] end, int n) {
        Arrays.sort(st);
        Arrays.sort(end);

        int count = 0;
        int ans = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (st[i] <= end[j]) {
                count++;
                ans = Math.max(count, ans);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

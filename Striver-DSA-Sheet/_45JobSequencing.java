import java.util.Arrays;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class _45JobSequencing {
    static int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);
        int[] done = new int[n];
        Arrays.fill(done, -1);
        int numJobsDone = 0;
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n - 1, arr[i].deadline - 1); j >= 0; j--) {
                if (done[j] == -1) {
                    done[j] = arr[i].id;
                    totalProfit += arr[i].profit;
                    numJobsDone++;
                    break;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = numJobsDone;
        ans[1] = totalProfit;
        return ans;
    }

    public static void main(String[] args) {

    }
}

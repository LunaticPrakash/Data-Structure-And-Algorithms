import java.util.Scanner;

public class _12_Min_Num_Jumps_To_End {
    private int getMinJumps1(int arr[], int n) {
        int jump[] = new int[n]; // jump[i] stores the num of jumps required to reach i from 0
        for (int i = 0; i < n; i++)
            jump[i] = Integer.MAX_VALUE;
        jump[0] = 0;

        //  finding num of jumps req to reach i from 0 with help of jump[]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // if j is reachable && from j, i is reachable
                if (jump[j] != Integer.MAX_VALUE && arr[j] + j >= i) {
                    if (jump[i] > jump[j] + 1) // making jump from j is more efficient to reach i
                        jump[i] = jump[j] + 1;
                }
            }
        }
        return jump[n-1] == Integer.MAX_VALUE ? -1 : jump[n-1];
    }

    private int getMinJumps2(int arr[], int n) {
        if (n == 0 || arr[0] == 0)
            return -1;
        int maxR = arr[0]; // maximum index that can be reached from indexes till i
        int step = arr[0]; // maximum number of possible steps we have
        int numJumps = 1; // total number of jumps made

        for (int i = 1; i < n; i++) {
            if (i == n - 1)
                return numJumps;
            maxR = Math.max(maxR, i + arr[i]);
            step--;
            if (step == 0) {
                numJumps++;
                if (i >= maxR)
                    return -1;
                step = maxR - i;
            }
        }
        return numJumps;
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

        _12_Min_Num_Jumps_To_End obj = new _12_Min_Num_Jumps_To_End();
        int result = obj.getMinJumps1(arr, n);
        System.out.println("Jumps = " + result);
        scan.close();
    }
}
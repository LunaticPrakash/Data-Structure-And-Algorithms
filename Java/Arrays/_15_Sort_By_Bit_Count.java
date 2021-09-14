import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Pairs {
    Integer x;
    int y;

    Pairs(Integer x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return this.x + ", " + this.y;
    }
}

public class _15_Sort_By_Bit_Count {

    private static int countBits(int a) {
        int count = 0;
        while (a > 0) {
            if ((a & 1) > 0)
                count += 1;
            a = a >> 1;
        }
        return count;
    }

    private static void sortBySetBitCount(Integer arr[], int n) {
        int[] bitCount = new int[n];
        Pairs[] pairs = new Pairs[n];
        for (int i = 0; i < n; i++)
            bitCount[i] = countBits(arr[i]);

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pairs(arr[i], bitCount[i]);
        }

        Arrays.sort(pairs, Comparator.comparingDouble(o -> -o.y));
        for (int i = 0; i < n; i++)
            arr[i] = pairs[i].x;
        for (int i = 0; i < n; i++)
            System.err.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your array elements :- ");
        String numbers[] = scan.nextLine().split(" ");
        Integer arr[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(numbers[i]);
        }

        sortBySetBitCount(arr, n);
    }
}

package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _29_Chocolate_Distribution {

    private static long minDiff(ArrayList<Long> a, long n, long m) {
        long min = Long.MIN_VALUE;
        Collections.sort(a);
        for (int i = 0; i < n - m + 1; i++) {
            int idx = (int) (i + m - 1);
            long d = a.get(idx) - a.get(i);
            if(d < min)
                min = d;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        long n = scan.nextLong();
        scan.nextLine();
        System.out.print("Enter M : ");
        long m = scan.nextLong();
        scan.nextLine();
        System.out.print("Enter your array elements :- ");
        String numbers[] = scan.nextLine().split(" ");
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(Long.valueOf(numbers[i]));

        minDiff(a, n, m);
    }
}

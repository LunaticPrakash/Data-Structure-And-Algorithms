import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Pair {
    int x;
    int y;

    Pair() {
    }

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.valueOf(x) + ", " + String.valueOf(y);
    }
}

public class _9_Pair_With_Diff_K {

    private static boolean getPair1(int arr[], int size, int k) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(arr[i] - arr[j]) == k)
                    list.add(new Pair(arr[i], arr[j]));
            }
        }

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        if (list.size() == 0)
            return false;
        return true;
    }

    private static boolean getPair2(int arr[], int size, int k) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;

        while (i < size && j < size) {
            if (i != j &&  arr[j] - arr[i] == k)
                return true;
            else if (arr[j] - arr[i] > k)
                i++;
            else
                j++;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr[] = new int[100];
        System.out.print("Enter length of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter k : ");
        int k = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter array element :- ");
        String line[] = scan.nextLine().split("\\s+");
        for (int i = 0; i < line.length; i++)
            arr[i] = Integer.parseInt(line[i]);

        System.out.println(getPair2(arr, n, k));
        scan.close();
    }
}

public class _1_PrintNumbers {

    // Print numbers from 1 to n: Recursion - Time: O(N) Space: O(N){for Recursion}
    public static void printNumRecusrion1(int i, int n) {
        if (i > n)
            return;
        System.out.print(i + " ");
        printNumRecusrion1(i + 1, n);
    }

    // Print numbers from 1 to n: Backtracking - Time: O(N) Space: O(N){for
    // Recursion}
    public static void printNumBacktrack1(int n) {
        if (n < 1)
            return;
        printNumBacktrack1(n - 1);
        System.out.print(n + " ");
    }

    // Print numbers from n to 1: Recursion - Time: O(N) Space: O(N){for Recursion}
    public static void printNumRecusrion2(int n) {
        if (n < 1)
            return;
        System.out.print(n + " ");
        printNumRecusrion2(n - 1);
    }

    // Print numbers from n to 1: Backtracking - Time: O(N) Space: O(N){for
    // Recursion}
    public static void printNumBacktrack2(int i, int n) {
        if (i > n)
            return;
        printNumBacktrack2(i + 1, n);
        System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.print("Print 1 to N (Using Recursion): ");
        printNumRecusrion1(1, n);
        System.out.print("\nPrint 1 to N (Using Backtracking): ");
        printNumBacktrack1(n);

        System.out.print("\nPrint N to 1 (Using Recursion): ");
        printNumRecusrion2(n);
        System.out.print("\nPrint N to 1 (Using Recursion): ");
        printNumBacktrack2(1, n);
    }
}
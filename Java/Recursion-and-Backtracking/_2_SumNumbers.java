public class _2_SumNumbers {
    // Sum from 1 to N: Parameterized Recusrion - Time:O(N) Space: O(N){for
    // Recursion}
    public static int sumNumbers1(int sum, int n) {
        if (n == 0)
            return sum;
        return sumNumbers1(sum + n, n - 1);
    }

    // Sum from 1 to N: Non-Parameterized Recusrion - Time:O(N) Space:
    // O(N){for Recursion}
    public static int sumNumbers2(int n) {
        if (n == 0 || n == 1)
            return n;
        return n + sumNumbers2(n - 1);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.print("\nSum 1 to N (Using Parameterized Recursion): " + sumNumbers1(0, n));
        System.out.print("\nSum 1 to N (Using Recursion without Parameter): " + sumNumbers2(n));
    }
}

public class _5_FibonacciNumber {
    
    // Fibonacci Number: Recursion - Time:O(2^N) Space: O(N){for Recursion}
    public static int fib(int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci Number: " + fib(n));
    }
}

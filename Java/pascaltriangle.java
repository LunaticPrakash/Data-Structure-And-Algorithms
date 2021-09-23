public class pascaltriangle {

    public static int factorial(int n) {
        if (n < 2)
            return 1;
        return n * factorial(n - 1);
    }

    public static int ncr(int n, int r) {
        return (int) (factorial(n) / (factorial(n - r) * factorial(r)));
    }

    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n + 1; i++) {
            System.out.print(" ".repeat(n - i));
            for (int j = 0; j <= i; j++) {
                System.out.print("" + ncr(i, j) + " ");
            }
            System.out.println();
        }
    }
}

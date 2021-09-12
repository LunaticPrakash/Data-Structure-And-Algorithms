package Strings;

public class flippingBits {
    public static String toBinary(long x) {
        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((x & mask) != 0 ? 1 : 0);
        }
        return result.toString();
    }

    public static String toBinary2(long x) {
        return Long.toBinaryString(x);
    }

    public static long toInteger(String bin) {
        long result = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1')
                result += (long) Math.pow(2, bin.length() - 1 - i);
        }
        return result;
    }

    public static int toInteger2(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public static long flippingBitsSolver(long n) {
        // Write your code here
        String bin = toBinary2(n);
        String result = "";
        for (int i = 0; i < bin.length(); i++) {
            char ch = bin.charAt(i);
            if (ch == '1')
                result += "0";
            else
                result += "1";
        }
        return toInteger(result);
    }

    public static void main(String[] args) {
        System.out.println(flippingBitsSolver(24));
    }
}

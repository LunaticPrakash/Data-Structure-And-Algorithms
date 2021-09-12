package Strings;

public class zigzagTraversal {

    public static String convert(String s, int n) {
        if (n == 1)
            return s;
        int len = s.length(), j = 0;
        if (n > len)
            n = len;
        String[] res = new String[n];
        boolean down = true;
        for (int i = 0; i < len; i++) {
            String chStr = String.valueOf(s.charAt(i));
            // res[j] += chStr;
            res[j] = res[j] == null ? chStr : res[j] + chStr;
            if (down == true) {
                j++;
                if (j == n) {
                    down = false;
                    j = j - 2;
                }
            } else {
                j--;
                if (j == -1) {
                    down = true;
                    j = j + 2;
                }
            }
        }
        String output = "";
        for (int i = 0; i < n; i++) {
            output += res[i];
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(convert("A", 2));
        System.out.println(1534236469 > Integer.MAX_VALUE);
    }

}

package Strings;

public class lcp {

    public static String lcpUtil(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
            i++;
        }
        return s1.substring(0, i);
    }

    public static String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++)
            res = lcpUtil(res, strs[i]);
        return res;
    }

    public static void main(String[] args) {
        String[] strs = { "flowers", "flow", "fl", "flaw" };
        System.out.println(longestCommonPrefix(strs));
    }
}
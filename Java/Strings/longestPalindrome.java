package Strings;

import java.util.Scanner;

public class longestPalindrome {

    public static String getLPS(String s) {
        int n = s.length(), start = 0, maxLen = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++){
            dp[i][i] = true;
            maxLen = 1;
        }

        int lowIdx = n+1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                if(i < lowIdx){
                    start = i;
                    lowIdx = i;
                }
            }
        }
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLen) {
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        System.out.println(getLPS(s));
    }
}

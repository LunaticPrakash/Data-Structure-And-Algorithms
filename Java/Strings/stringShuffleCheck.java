package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class stringShuffleCheck {

    public static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        s = String.valueOf(charArray);
        return s;
    }

    public static boolean checkShuffle(String s1, String s2, String res) {
        int i = 0, j = 0, k = 0;
        while (k < res.length()) {
            if (i < s1.length() && s1.charAt(i) == res.charAt(k))
                i++;
            else if (j < s2.length() && s2.charAt(j) == res.charAt(k))
                j++;
            else
                return false;
            k++;
        }
        if (i < s1.length() || j < s2.length())
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s1, s2, res;
        Scanner in = new Scanner(System.in);
        s1 = in.next();
        s2 = in.next();
        res = in.next();
        in.close();

        if (s1.length() + s2.length() != res.length())
            System.out.println("False");
        else {
            s1 = sortString(s1);
            s2 = sortString(s2);
            res = sortString(res);
            System.out.println(checkShuffle(s1, s2, res));
        }
    }
}

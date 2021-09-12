package Strings;

import java.util.ArrayList;
import java.util.List;

public class permutation {
    public static void main(String[] args) {
        String s = "Hello";
        List<String> ans1 = new ArrayList<>();

        System.out.println(permute1(s, 0, s.length() - 1, ans1));
    }

    public static String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char c = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = c;
        return String.valueOf(charArray);
    }

    public static List<String> permute1(String s, int l, int r, List<String> res) {
        if (l == r) {
            res.add(s);
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                permute1(s, l + 1, r, res);
                s = swap(s, l, i);
            }
        }
        return res;
    }
}

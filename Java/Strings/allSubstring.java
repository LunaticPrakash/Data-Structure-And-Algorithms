package Strings;

import java.util.ArrayList;

public class allSubstring {
    public static void main(String[] args) {
        String s = "abcd";
        ArrayList<String> result = new ArrayList<>();
        findSubsequence(s, "", result);
        System.out.println(result);
        System.out.println("Length = " + result.size());

    }

    public static void findSubsequence(String s, String ans, ArrayList<String> res) {
        if (s.length() == 0) {
            res.add(ans);
            return;
        }

        findSubsequence(s.substring(1), ans + s.charAt(0), res);
        findSubsequence(s.substring(1), ans, res);
    }
}

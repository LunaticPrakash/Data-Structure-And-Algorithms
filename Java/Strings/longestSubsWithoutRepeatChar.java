package Strings;

import java.util.HashSet;
import java.util.Set;

public class longestSubsWithoutRepeatChar {

    public static int lengthOfLongestSubstring1(String s) {

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int len = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                } else {
                    len++;
                    maxLen = len > maxLen ? len : maxLen;
                    set.add(c);
                }
            }
            set.remove(s.charAt(i));
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        String test = "";
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i));
            if (test.contains(curr)) {
                test = test.substring(test.indexOf(curr) + 1);
            }
            test = test + curr;
            maxLen = Math.max(test.length(), maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
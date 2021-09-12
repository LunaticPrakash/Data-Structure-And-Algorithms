package Strings;

import java.util.HashMap;
import java.util.Map;

public class remainingAnagrams {

    public static int remAnagrams(String s, String s1) {
        // add code here.
        HashMap<Character, Integer> freq1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq1.containsKey(c))
                freq1.put(c, freq1.get(c) + 1);
            else
                freq1.put(c, 1);
        }

        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (freq1.containsKey(c))
                freq1.put(c, freq1.get(c) - 1);
            else {
                if (freq2.containsKey(c))
                    freq2.put(c, freq2.get(c) + 1);
                else
                    freq2.put(c, 1);
            }
        }

        int res = 0;
        for (Map.Entry<Character, Integer> m : freq1.entrySet()) {
            if (m.getValue() != 0)
                res = res + Math.abs(m.getValue());
        }

        for (Map.Entry<Character, Integer> m : freq2.entrySet()) {
            if (m.getValue() != 0)
                res = res + Math.abs(m.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "basgadhbfgvhads";
        String s2 = "sjdhgvjdsbhvbvd";

        System.out.println(remAnagrams(s1, s2));
    }
}

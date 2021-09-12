package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class checkIsomorphic {

    public static boolean isIsomorphic(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 != n2)
            return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n1; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1) != c2)
                    return false;
            }
            else{
                if(set.contains(c2))
                    return false;
                map.put(c1,c2);
                set.add(c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcaabbd";
        String s2 = "xyzxxyyp";

        System.out.println(isIsomorphic(s1, s2));
    }
}

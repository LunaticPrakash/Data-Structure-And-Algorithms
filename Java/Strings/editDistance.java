package Strings;

import java.util.HashMap;

public class editDistance {

    public static String concat(int n1, int n2) {
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);

        return s1 + "," + s2;
    }

    public static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        return z;
    }

    public static int solve(String s, String t, int n1, int n2, HashMap<String, Integer> memo) {
        String key = concat(n1, n2);
        if (n1 == 0)
            return n2;
        if (n2 == 0)
            return n1;
        if (memo.containsKey(key))
            return memo.get(key);
        if (s.charAt(n1 - 1) == t.charAt(n2 - 1))
            return solve(s, t, n1 - 1, n2 - 1, memo);
        memo.put(key, (1 + min(solve(s, t, n1 - 1, n2, memo), solve(s, t, n1, n2 - 1, memo),
                solve(s, t, n1 - 1, n2 - 1, memo))));
        return memo.get(key);
    }

    public static int editDistanceFun(String s, String t) {
        // Code here
        int res = solve(s, t, s.length(), t.length(), new HashMap<String, Integer>());
        return res;
    }

    public static void main(String[] args) {
        String s1 = "bblxnaxvixupiutnpftipsrmeucrytdokhktfdlhxhuqbaohkziqjbzuytnmlgokxepjtbrmwiomnuozvbjwbqirtjvjzkbtvbph";
        String s2 = "wcdqbbvhbnzvwkwjvcuohwbgqmrglpxlibswcpnjwpyhpvamuknvkpgyagsckvivxlytbrkmwkhqeyrsqkjzinnairxgfc";

        System.out.println(editDistanceFun(s1, s2));
    }
}

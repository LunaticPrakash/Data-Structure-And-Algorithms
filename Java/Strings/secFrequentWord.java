package Strings;

import java.util.HashMap;
import java.util.Map;

public class secFrequentWord {

    static String secFrequent(String arr[], int N) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else {
                map.put(s, 1);
            }
        }

        int f = Integer.MIN_VALUE, s = Integer.MIN_VALUE;
        String result = arr[0];
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() > f) {
                s = f;
                f = m.getValue();
            } else if (m.getValue() > s && m.getValue() < f) {
                s = m.getValue();
            }
        }
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == s) {
                result = m.getKey();
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s = { "ghi", "ghi", "aaa", "ghi", "ghi", "ghi", "ghi" };
        System.out.println(secFrequent(s, 7));
    }
}

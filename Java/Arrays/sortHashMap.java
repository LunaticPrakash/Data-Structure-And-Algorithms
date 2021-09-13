package Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class sortHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(-1, 0);
        map.put(1, -2);
        map.put(31, 2);
        map.put(2, 82);
        map.put(7, 3);
        map.put(5, 6);

        System.out.println(map);
        
        TreeMap<Integer, Integer> sortByKeys = new TreeMap<>(map);
        System.out.println(sortByKeys);

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Integer> sortByValue = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> m : list) {
            sortByValue.put(m.getKey(), m.getValue());
        }
        System.out.println(sortByValue);
    }
}

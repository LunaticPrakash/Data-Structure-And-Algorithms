package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class _25_Elements_More_Than_N_by_K {

    private List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > n / 3)
                result.add(m.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your array elements :- ");
        String numbers[] = scan.nextLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(numbers[i]);
        }
        _25_Elements_More_Than_N_by_K obj = new _25_Elements_More_Than_N_by_K();
        obj.majorityElement(arr);
    }
}

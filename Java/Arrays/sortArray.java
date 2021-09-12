import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sortArray {
    public static void main(String[] args) {
        int[] arr1 = { 4, 3, 2, 1 };
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + " ");
        System.out.println();
        int[][] arr2 = { { 1, 4, 2 }, { 5, 3, 1 } };


        Arrays.sort(arr2, Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < arr2.length; i++)
            for (int j = 0; j < arr2[0].length; j++)
                System.out.print(arr2[i][j] + " ");

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(4, 3, 5, 2, 19, -3, 6));
        Collections.sort(arr3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*(-1);
            }
        });
        System.out.println();
        System.out.println(arr3);
    }
}
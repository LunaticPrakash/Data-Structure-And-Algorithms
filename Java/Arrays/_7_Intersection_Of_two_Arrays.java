package Arrays;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _7_Intersection_Of_two_Arrays {
    public ArrayList<Integer> intersectionOfArray(int arr1[], int n1, int arr2[], int n2) {
        ArrayList<Integer> intersec = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j]) {
                    intersec.add(arr1[i]);
                }
            }
        }
        return intersec;
    }

    public void intersectionOfArray2(int arr1[], int n1, int arr2[], int n2) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            frequencyMap.put(arr1[i], 0);
        }

        for (int i = 0; i < n2; i++) {
            if (frequencyMap.containsKey(arr2[i]))
                frequencyMap.put(arr2[i], 1);
        }

        for(Map.Entry<Integer,Integer> e : frequencyMap.entrySet()){
            if(frequencyMap.get(e.getKey()) == 1)
                System.out.print(e.getKey() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of 1st array : ");
        int n1 = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your 1st array element :- ");
        String numbers[] = scan.nextLine().split(" ");
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.valueOf(numbers[i]);
        }

        System.out.print("\nEnter size of 2nd array : ");
        int n2 = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your 2nd array element :- ");
        numbers = scan.nextLine().split(" ");
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.valueOf(numbers[i]);
        }

        scan.close();

        _7_Intersection_Of_two_Arrays obj = new _7_Intersection_Of_two_Arrays();
        ArrayList<Integer> intersec = obj.intersectionOfArray(arr1, n1, arr2, n2);
        obj.intersectionOfArray2(arr1, n1, arr2, n2);

        // System.out.print("\nIntersection :- ");
        // for (int i = 0; i < intersec.size(); i++) {
        //     System.out.print(intersec.get(i) + " ");
        // }

    }

}

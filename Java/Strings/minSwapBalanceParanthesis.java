package Strings;

public class minSwapBalanceParanthesis {

    static long swapCount(String str) {
        char[] ch = str.toCharArray();
        int left = 0, right = 0, imbalance = 0, swap = 0;
        for (Character c : ch) {
            if (c == '[') {
                left++;
                if(imbalance > 0){
                    swap = swap + imbalance;
                    imbalance--;
                }
            } else if(c == ']') {
                right++;
                imbalance = right - left;
            }
        }
        return swap;
    }

    public static void main(String[] args) {

    }
}

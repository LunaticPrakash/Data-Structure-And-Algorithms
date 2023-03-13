import java.util.Arrays;

public class _1_ReverseWordsInString {
    public String reverseWords1(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        str = Arrays.stream(str).filter(w -> !w.isBlank()).toArray(String[]::new);
        reverse(str, 0, str.length - 1);
        return String.join(" ", str);
    }

    public void reverse(String[] s, int start, int end) {
        while (start < end) {
            String temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseWords2(String s) {
        String ans = "";
        return ans;
    }

    public static void main(String[] args) {

    }
}

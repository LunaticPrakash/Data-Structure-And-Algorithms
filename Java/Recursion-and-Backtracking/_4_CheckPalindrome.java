public class _4_CheckPalindrome {

    // Check Palindrome: Parameterized Recursion - Time:O(N) Space: O(N){for
    // Recursion}
    public static boolean checkPalindrome1(String s, int start, int end) {
        if (start > end)
            return true;
        if (s.charAt(start) != s.charAt(end))
            return false;
        return checkPalindrome1(s, start + 1, end - 1);
    }

    // Check Palindrome: Parameterized Recursion - Time:O(N) Space: O(N){for
    // Recursion}
    public static boolean checkPalindrome2(String s, int i) {
        if (i > s.length()/2)
            return true;
        if (s.charAt(i) != s.charAt(s.length()-1-i))
            return false;
        return checkPalindrome2(s, i+1);
    }

    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(
                "Check Palindrome (Using Parameterized Recursion): " + checkPalindrome1(str, 0, str.length() - 1));
        System.out.println(
                "Check Palindrome (Using Parameterized Backtracking): " + checkPalindrome2(str, 0));
    }
}

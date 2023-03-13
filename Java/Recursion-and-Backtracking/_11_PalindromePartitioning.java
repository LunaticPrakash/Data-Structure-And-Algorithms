import java.util.ArrayList;
import java.util.List;

public class _11_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<List<String>>();

        solve(s, 0, temp, res);
        return res;
    }

    public void solve(String s, int idx, List<String> temp, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                temp.add(s.substring(idx, i + 1));
                solve(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

import java.util.HashSet;
import java.util.Set;

public class commonChar {

    public static String getCommon(String s1, String s2) {
        String result = "";
        Set<Character> seen = new HashSet<>();
        for (char c : s1.toCharArray())
            seen.add(c);
        for (char c : s2.toCharArray()) {
            if (seen.contains(c))
                result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getCommon("e", "beads"));
    }
}

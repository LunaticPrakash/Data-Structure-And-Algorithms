import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tuple {
    public int start;
    public int end;
    public int pos;

    Tuple(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "pos: " + pos + " start: " + start + " end: " + end;
    }
}

public class _1_NMeetingsInRoom {

    public static void maxMeetings(int[] start, int[] end, int n) {
        Tuple[] meets = new Tuple[n];

        for (int i = 0; i < n; i++) {
            meets[i] = new Tuple(start[i], end[i], i);
        }

        Arrays.sort(meets, (m1, m2) -> m1.end != m2.end ? m1.end - m2.end : m1.pos - m2.pos);

        List<Integer> ans = new ArrayList<>();
        ans.add(meets[0].pos);
        int endLimit = meets[0].end;

        for (int i = 1; i < n; i++) {
            if (meets[i].start > endLimit) {
                endLimit = meets[i].end;
                ans.add(meets[i].pos);
            }
        }
        System.out.println(ans.toString());
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        int n = 6;
        maxMeetings(start, end, n);
    }

    
}
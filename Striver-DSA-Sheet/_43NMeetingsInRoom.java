import java.util.ArrayList;
import java.util.Collections;

class Meeting {
    int pos;
    int start;
    int end;

    public Meeting(int pos, int start, int end) {
        this.pos = pos;
        this.start = start;
        this.end = end;
    }
}

public class _43NMeetingsInRoom {

    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(i + 1, start[i], end[i]));
        }

        Collections.sort(meetings, (m1, m2) -> m1.end != m2.end ? m1.end - m2.end : m1.pos - m2.pos);
        int ans = 1;
        int limit = meetings.get(0).end;
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > limit) {
                ans++;
                limit = meetings.get(i).end;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class _28RemoveNthNodeEnd {

    // Approach - 1 Time: O(2N) Space: O(1)
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = head;
        int l = 0;
        while (temp != null) {
            temp = temp.next;
            l++;
        }
        int fromFront = l - n;
        if (fromFront == 0)
            return head.next;
        temp = head;
        while (fromFront > 1 && temp != null) {
            temp = temp.next;
            fromFront--;
        }
        ListNode delNode = temp.next;
        temp.next = delNode.next;
        return head;
    }

    public static void main(String[] args) {

    }
}

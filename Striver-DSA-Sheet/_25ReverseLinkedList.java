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

public class _25ReverseLinkedList {

    // Approach - 1 Time: O(N) Space: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}

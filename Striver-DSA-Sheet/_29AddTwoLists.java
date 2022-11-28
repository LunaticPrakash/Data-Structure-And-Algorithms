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

public class _29AddTwoLists {

    // Approach - 1 Time: O(2N) Space: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode res = addListUtils(l1, l2);
        // res = reverse(res);
        return res;
    }

    private ListNode addListUtils(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;
        ListNode res = new ListNode();
        ListNode temp = res;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum >= 10 ? 1 : 0;
            temp.next = new ListNode(sum);
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum >= 10 ? 1 : 0;
            temp.next = new ListNode(sum);
            l2 = l2.next;
            temp = temp.next;
        }

        if(carry>0)
        temp.next = new ListNode(carry);
        return res.next;
    }

    // private ListNode reverse(ListNode l2) {
    //     ListNode pre = null, curr = l2, nex = null;
    //     while (curr != null) {
    //         nex = curr.next;
    //         curr.next = pre;
    //         pre = curr;
    //         curr = nex;
    //     }
    //     return pre;
    // }

    public static void main(String[] args) {

    }
}

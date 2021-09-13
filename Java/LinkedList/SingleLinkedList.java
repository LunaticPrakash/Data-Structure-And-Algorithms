package LinkedList;

import java.util.HashSet;
import java.util.Scanner;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    public Node insertAtBeg(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public Node insertAtEnd(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);
        }
        return head;
    }

    public Node insertAtIndex(Node head, int index, int data) {
        if (index < 0)
            return head;
        else if (head == null && index != 0)
            return head;
        else if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++)
                temp = temp.next;
            if (temp.next == null)
                return head;
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
    }

    public Node deleteByData(Node head, int data) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else if (head.data == data) {
            head = head.next;
            System.out.println("\nDeleted : " + data + "\n");
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.data != data)
                temp = temp.next;
            if (temp.next == null)
                return head;
            Node delNode = temp.next;
            temp.next = delNode.next;
            System.out.println("\nDeleted : " + delNode.data + "\n");
        }
        return head;
    }

    public Node deleteByIndex(Node head, int index) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else if (index < 0)
            System.out.println("\n Invalid Index");
        else if (index == 0) {
            System.out.println("\nDeleted : " + head.data);
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++)
                temp = temp.next;
            if (temp.next == null)
                return head;
            Node delNode = temp.next;
            temp.next = delNode.next;
            System.out.println("\nDeleted : " + head.data);
        }
        return head;
    }

    public Node deleteAlternatNode(Node head) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else {
            Node curr = head;
            Node del = head.next;

            while (curr != null && del != null) {
                curr.next = del.next;
                curr = curr.next;
                if (curr != null)
                    del = curr.next;
            }
        }
        return head;
    }

    public Node getMiddleElement(Node head) {
        if (head == null) {
            System.out.println("\nLinked List is empty!");
            return head;
        } else {
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public Node middle(Node start, Node end) {
        if (start == null)
            return null;

        Node slow = start;
        Node fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean binarySearch(Node head, Node end, int key) {
        if (head == null || head == end)
            return false;
        Node mid = middle(head, end);
        if (mid == null)
            return false;

        else if (mid.data == key)
            return true;

        else if (mid.next == null)
            return false;

        else if (mid.data < key)
            return binarySearch(mid, end, key);

        else if (mid.data > key)
            return binarySearch(head, mid, key);

        return false;
    }

    public boolean checkLoop(Node head) {
        if (head == null || head.next == null)
            return false;
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public Node getStartLoop(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public int lengthLoop(Node head) {
        if (head == null || head.next == null)
            return 0;

        Node slow = head.next;
        Node fast = head.next.next;
        int count = 0;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                while (slow.next != fast) {
                    slow = slow.next;
                    count++;
                }
                count++;
                return count;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return count;
    }

    public Node removeLoop(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == head) {
            while (fast.next != head)
                fast = fast.next;
            fast.next = null;
        } else if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        return head;
    }

    public Node reverse(Node head) {
        Node pre = null, curr = head, nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }
        return pre;
    }

    public Node reverseRec(Node head) {
        if (head == null || head.next == null)
            return head;
        Node rest = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public Node reverseGroup(Node head, int k) {
        if (head == null) // head.next == null for 1 element to reverse it fails
            return head;

        Node pre = null, curr = head, nex = null;
        int count = 0;
        while (count < k && curr != null) {
            nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
            count++;
        }

        if (nex != null) {
            head.next = reverseGroup(nex, k);
        }
        return pre;
    }

    public Node removeDuplicatesSorted(Node head) {
        Node first = head;
        while (first != null) {
            Node second = first.next;
            while (second != null && first.data == second.data)
                second = second.next;
            first.next = second;
            first = first.next;
        }
        return head;
    }

    public Node removeDuplicatesSortedRec(Node head) {
        if (head != null && head.next != null) {
            if (head.data == head.next.data) {
                Node del = head.next;
                head.next = del.next;
                removeDuplicatesSortedRec(head);
            } else {
                removeDuplicatesSortedRec(head.next);
            }
        }
        return head;
    }

    public Node removeDuplicatesUnsortedRec(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node pre = null, curr = head;
        while (curr != null) {
            int currval = curr.data;
            if (set.contains(currval)) {
                pre.next = curr.next;
            } else {
                set.add(currval);
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public Node moveLastToFront(Node head) {
        if (head == null)
            return head;

        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        Node lastNode = temp.next;
        temp.next = null;
        lastNode.next = head;
        head = lastNode;
        return head;
    }

    // L0 → L1 → … → Ln - 1 → Ln
    // Reorder the list to be on the following form:
    // L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 ->
    public Node alternateMerge(Node head1, Node head2) {
        Node head = head1;
        while (head1 != null && head2 != null) {
            Node temp = head1.next;
            head1.next = head2;
            head1 = temp;

            temp = head2.next;
            head2.next = head1;
            head2 = temp;
        }
        return head;
    }

    public Node reorder(Node head) {
        Node head2 = getMiddleElement(head);
        head2 = reverse(head2);
        head = alternateMerge(head, head2);
        return head;
    }

    public int length(Node head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public int getNumber(Node head) {
        if (head != null) {
            int n = length(head);
            n = (int) (Math.pow(10, n - 1));
            Node curr = head;
            int num = 0;
            while (curr != null) {
                num = num + curr.data * n;
                curr = curr.next;
                n = n / 10;
            }
            return num;
        }
        return -111111;
    }

    public Node addOneUtils(Node head) {

        Node res = head, temp = null;
        int carry = 1, sum = 0;
        while (head != null) {
            sum = carry + head.data;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            head.data = sum;
            temp = head;
            head = head.next;
        }
        if (carry > 0)
            temp.next = new Node(carry);
        return res;
    }

    public Node addOne(Node head) {
        if (head == null)
            return head;
        head = reverse(head);
        head = addOneUtils(head);
        head = reverse(head);
        return head;
    }

    public Node addListUtils(Node h1, Node h2) {
        Node head3 = new Node(0), res = head3;
        int carry = 0, sum = 0;
        while (h1 != null && h2 != null) {
            sum = carry + h1.data + h2.data;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            head3.next = new Node(sum);
            head3 = head3.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        while (h1 != null) {
            sum = carry + h1.data;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            head3.next = new Node(sum);
            head3 = head3.next;
            h1 = h1.next;
        }

        while (h2 != null) {
            sum = carry + h2.data;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            head3.next = new Node(sum);
            head3 = head3.next;
            h2 = h2.next;
        }
        if (carry > 0)
            head3.next = new Node(carry);

        return res.next;
    }

    public Node addTwoLists(Node first, Node second) {
        if (first == null)
            return second;
        else if (second == null)
            return first;
        else {
            first = reverse(first);
            second = reverse(second);

            Node head3 = addListUtils(first, second);
            head3 = reverse(head3);
            return head3;
        }
    }

    // public Node multiplyListsUtil(Node h1, Node h2) {
    // Node h3 = null, res = h3;
    // int prod = 1, carry = 0;
    // while (h1 != null && h2 != null) {
    // prod = carry + h1.data * h2.data;
    // carry = prod - (prod / 10) * 10;
    // h3.data = prod % 10;
    // }
    // }

    // public Node multiplyLists(Node h1, Node h2) {
    // if (h1 == null)
    // return h2;
    // if (h2 == null)
    // return h1;
    // h1 = reverse(h1);
    // h2 = reverse(h2);

    // Node h3 = multiplyListsUtil(h1, h2);
    // h3 = reverse(h3);
    // }

    public Node findIntersection(Node head1, Node head2) {
        Node head3 = new Node(0), res = head3;
        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                head3.next = new Node(head1.data);
                head3 = head3.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data > head2.data)
                head2 = head2.next;
            else
                head1 = head1.next;
        }
        return res;
    }

    public Node getIntersectionPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;
        else {
            HashSet<Node> set = new HashSet<>();
            while (head1 != null) {
                set.add(head1);
                head1 = head1.next;
            }

            while (head2 != null) {
                if (set.contains(head2))
                    return head2;
                head2 = head2.next;
            }
        }
        return null;
    }

    public Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        Node result = null;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else if (left.data > right.data) {
            result = right;
            result.next = merge(left, right.next);
        }
        result.next = null;
        return result;
    }

    public Node mergeSort(Node head) {
        if (head != null && head.next != null) {
            Node mid = getMiddleElement(head);
            if (mid != null) {
                Node nextOfMid = mid.next;
                mid.next = null;
                Node left = mergeSort(head);
                Node right = mergeSort(nextOfMid);
                Node sortedList = merge(left, right);
                return sortedList;
            }
        }
        return head;
    }

    public boolean isPalindrome(Node head) {
        if (head == null)
            return true;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        Node pre = null, curr = slow, nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }
        fast = head;
        while (fast != null && pre != null) {
            if (fast.data != pre.data)
                return false;
            fast = fast.next;
            pre = pre.next;
        }
        return true;
    }

    int count = 0;

    public void nthNodeEnd(Node head, int n) {
        if (head == null)
            return;
        nthNodeEnd(head.next, n);
        if (++count == n) {
            System.out.println("Nth Node from end = " + head.data);
        }
    }

    public Node nthNodeEnd2(Node head, int n) {
        Node p1 = head, p2 = head;
        int count = 0;

        while (p1 != null && count < n) {
            p1 = p1.next;
            count++;
        }
        if (p1 == null && count == n)
            return head;
        if (p1 == null && count != n)
            return null;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p2.data);
        return p2;
    }

    public Node delNthNodeEnd2(Node head, int n) {
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while (p1 != null && count < n + 1) {
            p1 = p1.next;
            count++;
        }

        if (p1 == null && count == n) {
            head = head.next;
            return head;
        }

        if (p1 == null && count != n)
            return head;

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2 != null && p2.next != null) {
            Node delNode = p2.next;
            if (delNode != null)
                p2.next = delNode.next;
        }
        return head;
    }

    public Node removeAllOccuDupl(Node head) {
        Node curr = head;
        Node pre = new Node(0);
        pre.next = curr;
        while (curr != null) {
            while (curr.next != null && pre.next.data == curr.next.data)
                curr = curr.next;
            if (pre.next == curr)
                pre = pre.next;
            else
                pre.next = curr.next;
            curr = curr.next;
        }
        head = pre.next;
        return head;
    }

    public void display(Node head) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}

public class SingleLinkedList {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        LinkedList list = new LinkedList();
        Node head = null;

        int choice = 1, a = 1;
        while (choice != 5) {
            System.out.println("\n1.Insert\n2.Delete\n3.Display\n4.Extras\n5.Exit\n");
            choice = in.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("\nEnter data to insert : ");
                    int data = in.nextInt();
                    System.out.println("\n1. Insert at start\n2. Insert at last\n3. Insert at index\n");
                    a = in.nextInt();
                    if (a == 1)
                        head = list.insertAtBeg(head, data);
                    else if (a == 2)
                        head = list.insertAtEnd(head, data);
                    else if (a == 3) {
                        System.out.print("\nEnter index :- ");
                        int index = in.nextInt();
                        head = list.insertAtIndex(head, index, data);
                    }
                    list.display(head);
                    break;

                case 2:
                    System.out.println("\n1. Delete by data\n2. Delete by Index\n3. Delete Alternate Nodes\n");
                    a = in.nextInt();
                    if (a == 1) {
                        System.out.print("\nEnter data to delete : ");
                        data = in.nextInt();
                        head = list.deleteByData(head, data);
                    } else if (a == 2) {
                        System.out.print("\nEnter index :- ");
                        int index = in.nextInt();
                        head = list.deleteByIndex(head, index);
                    } else if (a == 3) {
                        head = list.deleteAlternatNode(head);
                    }
                    list.display(head);
                    break;

                case 3:
                    list.display(head);
                    break;

                case 4:
                    System.out.println("\n1. Middle Element\n2. Binary Search\n3. Check Loop\n4. Remove Loop"
                            + "\n5. Reverse" + "  \n6. Remove Duplicates\n7. Move Last to Front"
                            + "\n8. Reorder List (LeetCode)\n9. Get Number\n10. Add One\n11. Intersection"
                            + "\n12. Add two linked list numerically\n13. Intersection Point" + "\n14. Merge Sort"
                            + "\n15. Check Palindrome\n16. Nth Node from end\n17. Delete Nth Node from End"
                            + "\n18. Remove all occurrence of Duplicates\n");
                    a = in.nextInt();
                    if (a == 1)
                        System.out.println("\nMiddle Element = " + list.getMiddleElement(head));
                    else if (a == 2) {
                        System.out.print("\nEnter element to search :- ");
                        int key = in.nextInt();
                        System.out.println("\nFound at index = " + list.binarySearch(head, null, key));
                    } else if (a == 3) {
                        head.next.next = head;
                        System.out.println("\nLoop Exist = " + list.checkLoop(head));
                        System.out.println("\nLength of Loop = " + list.lengthLoop(head));
                    } else if (a == 4)
                        head = list.removeLoop(head);
                    else if (a == 5)
                        head = list.reverseGroup(head, 3);
                    else if (a == 6)
                        head = list.removeDuplicatesSortedRec(head);
                    else if (a == 7)
                        head = list.moveLastToFront(head);
                    else if (a == 8)
                        head = list.reorder(head);
                    else if (a == 9)
                        System.out.println("\nNumber = " + list.getNumber(head));
                    else if (a == 10)
                        head = list.addOne(head);
                    else if (a == 11) {
                        Node head2 = null;
                        head2 = list.insertAtEnd(head2, 12);
                        Node head3 = list.findIntersection(head, head2);
                        list.display(head3.next);
                    } else if (a == 12) {
                        Node head2 = null;
                        head2 = list.insertAtEnd(head2, 3);
                        head2 = list.insertAtEnd(head2, 5);
                        head2 = list.insertAtEnd(head2, 7);
                        Node head3 = list.alternateMerge(head, head2);
                        list.display(head3);
                    } else if (a == 13) {
                        Node head2 = null;
                        head2 = list.insertAtEnd(head2, 10);
                        head2 = list.insertAtEnd(head2, 15);
                        head2 = list.insertAtEnd(head2, 30);

                        head.next.next.next = head2.next;
                        System.out.println("LHS = " + head.next.next.next);
                        System.out.println("RHS = " + head2.next);
                        Node inter = list.getIntersectionPoint(head, head2);
                        System.out.println("Intersection Point = " + inter.data);
                    } else if (a == 14)
                        list.mergeSort(head);
                    else if (a == 15)
                        System.out.println("\nPalindrome = " + list.isPalindrome(head));
                    else if (a == 16) {
                        System.out.print("Enter n :- ");
                        int n = in.nextInt();
                        System.out.println("Nth Node from end = " + list.nthNodeEnd2(head, n));
                    } else if (a == 17) {
                        System.out.print("Enter n :- ");
                        int n = in.nextInt();
                        head = list.delNthNodeEnd2(head, n);
                        list.display(head);
                    } else if (a == 18)
                        head = list.removeAllOccuDupl(head);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("\nWrong Choice!");
            }
        }
        in.close();

    }
}
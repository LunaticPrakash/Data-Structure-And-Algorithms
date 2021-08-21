import java.util.HashSet;
import java.util.Scanner;

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {

    public Node<T> insertAtBeg(Node<T> head, T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Mid = " + String.valueOf(head.data));
        return head;
    }

    public Node<T> insertAtEnd(Node<T> head, T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node<T>(data);
        }
        return head;
    }

    public Node<T> insertAtIndex(Node<T> head, int index, T data) {
        if (index < 0)
            return head;
        else if (head == null && index != 0)
            return head;
        else if (index == 0) {
            Node<T> newNode = new Node<T>(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++)
                temp = temp.next;
            if (temp.next == null)
                return head;
            Node<T> newNode = new Node<>(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
    }

    public Node<T> deleteByData(Node<T> head, T data) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else if (head.data == data) {
            head = head.next;
            System.out.println("\nDeleted : " + data + "\n");
        } else {
            Node<T> temp = head;
            while (temp.next != null && temp.next.data != data)
                temp = temp.next;
            if (temp.next == null)
                return head;
            Node<T> delNode = temp.next;
            temp.next = delNode.next;
            System.out.println("\nDeleted : " + delNode.data + "\n");
        }
        return head;
    }

    public Node<T> deleteByIndex(Node<T> head, int index) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else if (index < 0)
            System.out.println("\n Invalid Index");
        else if (index == 0) {
            System.out.println("\nDeleted : " + head.data);
            head = head.next;
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++)
                temp = temp.next;
            if (temp.next == null)
                return head;
            Node<T> delNode = temp.next;
            temp.next = delNode.next;
            System.out.println("\nDeleted : " + head.data);
        }
        return head;
    }

    public Node<T> deleteAlternatNode(Node<T> head) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else {
            Node<T> curr = head;
            Node<T> del = head.next;

            while (curr != null && del != null) {
                curr.next = del.next;
                curr = curr.next;
                if (curr != null)
                    del = curr.next;
            }
        }
        return head;
    }

    public Node<T> getMiddleElement(Node<T> head) {
        if (head == null) {
            System.out.println("\nLinked List is empty!");
            return null;
        } else {
            Node<T> slow = head;
            Node<T> fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public Node<T> middle(Node<T> start, Node<T> end) {
        if (start == null)
            return null;

        Node<T> slow = start;
        Node<T> fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean binarySearch(Node<T> head, Node<T> end, T key) {
        if (head == null || head == end)
            return false;
        Node<T> mid = middle(head, end);
        if (mid == null)
            return false;

        else if (mid.data == key)
            return true;

        else if (mid.next == null)
            return false;

        else if (Integer.valueOf(String.valueOf(mid.data)) < Integer.valueOf(String.valueOf(key)))
            return binarySearch(mid, end, key);

        else if (Integer.valueOf(String.valueOf(mid.data)) > Integer.valueOf(String.valueOf(key)))
            return binarySearch(head, mid, key);

        return false;
    }

    public boolean checkLoop(Node<T> head) {
        if (head == null || head.next == null)
            return false;
        Node<T> slow = head.next;
        Node<T> fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next;
        }
        return false;
    }

    public Node<T> getStartLoop(Node<T> head) {
        if (head == null || head.next == null)
            return null;

        Node<T> slow = head.next;
        Node<T> fast = head.next.next;
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
            fast = fast.next;
        }
        return null;
    }

    public int lengthLoop(Node<T> head) {
        if (head == null || head.next == null)
            return 0;

        Node<T> slow = head.next;
        Node<T> fast = head.next.next;
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

    public Node<T> removeLoop(Node<T> head) {
        if (head == null || head.next == null)
            return head;
        Node<T> slow = head.next;
        Node<T> fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == head) {
            while (slow.next != slow)
                slow = slow.next;
            slow.next = null;
        }

        else if (slow == fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        return head;
    }

    public Node<T> reverse(Node<T> head) {
        Node<T> pre = null, curr = head, nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }
        return pre;
    }

    public Node<T> reverseRec(Node<T> head) {
        if (head == null || head.next == null)
            return head;
        Node<T> rest = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public Node<T> reverseGroup(Node<T> head, int k) {
        if (head == null) // head.next == null for 1 element to reverse it fails
            return head;

        Node<T> pre = null, curr = head, nex = null;
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

    public Node<T> removeDuplicatesSorted(Node<T> head) {
        Node<T> first = head;
        while (first != null) {
            Node<T> second = first.next;
            while (second != null && first.data == second.data)
                second = second.next;
            first.next = second;
            first = first.next;
        }
        return head;
    }

    public Node<T> removeDuplicatesSortedRec(Node<T> head) {
        if (head != null && head.next != null) {
            if (head.data == head.next.data) {
                Node<T> del = head.next;
                head.next = del.next;
                removeDuplicatesSortedRec(head);
            } else {
                removeDuplicatesSortedRec(head.next);
            }
        }
        return head;
    }

    public Node<T> removeDuplicatesUnsortedRec(Node<T> head) {
        HashSet<T> set = new HashSet<>();
        Node<T> pre = null, curr = head;
        while (curr != null) {
            T currval = curr.data;
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

    public Node<T> moveLastToFront(Node<T> head) {
        if (head == null)
            return head;

        Node<T> temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        Node<T> lastNode = temp.next;
        temp.next = null;
        lastNode.next = head;
        head = lastNode;
        return head;
    }

    // L0 → L1 → … → Ln - 1 → Ln
    // Reorder the list to be on the following form:
    // L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 ->
    public Node<T> alternateMerge(Node<T> head1, Node<T> head2) {
        Node<T> head = head1;
        while (head1.next != null && head2.next != null) {
            Node<T> temp = head1.next;
            head1.next = head2;
            head1 = temp;

            temp = head2.next;
            head2.next = head1;
            head2 = temp;
        }
        return head;
    }

    public Node<T> reorder(Node<T> head) {
        Node<T> head2 = getMiddleElement(head);
        head2 = reverse(head2);
        head = alternateMerge(head, head2);
        return head;
    }

    public int length(Node<T> head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public void display(Node<T> head) {
        if (head == null)
            System.out.println("\nLinked List is empty!");
        else {
            Node<T> temp = head;
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
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> head = null;

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
                            + "\n8. Reorder List (LeetCode)\n9. Get Number\n");
                    a = in.nextInt();
                    if (a == 1)
                        System.out.println("\nMiddle Element = " + list.getMiddleElement(head));
                    else if (a == 2) {
                        System.out.print("\nEnter element to search :- ");
                        int key = in.nextInt();
                        System.out.println("\nFound at index = " + list.binarySearch(head, null, key));
                    } else if (a == 3) {
                        System.out.println("\nLoop Exist = " + list.checkLoop(head));
                        System.out.println("\nLength of Loop = " + list.lengthLoop(head));
                    } else if (a == 4)
                        head = list.removeLoop(head);
                    else if (a == 5)
                        head = list.reverseGroup(head, 3);
                    else if (a == 6)
                        head = list.removeDuplicatesSortedRec(head);
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
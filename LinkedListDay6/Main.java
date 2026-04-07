import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {

    // 🔍 Detect Cycle (Floyd's Algo)
    // TC: O(n), SC: O(1)
    public static boolean cycleExistsOrNot(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 step

            if (slow == fast) return true; // cycle found
        }
        return false;
    }

    // 🔍 Length of Loop
    // TC: O(n), SC: O(1)
    public static int lengthOfLoop(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int count = 1;
                Node temp = slow.next;

                // loop complete hone tak count karo
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }
        return 0;
    }

    // 🔍 Starting Node of Loop
    // TC: O(n), SC: O(1)
    public static Node startNodeOfLoop(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // 🔍 Delete Middle Node
    // TC: O(n), SC: O(1)
    public static Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next; // delete
        return head;
    }

    // 🔍 Rotate LL by K
    // TC: O(n), SC: O(1)
    public static Node rotateLLbyK(Node head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        Node tail = head;

        // length + tail
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        tail.next = head; // circular

        int steps = len - k;
        Node newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // 🔍 Merge Two Sorted LL
    // TC: O(n+m), SC: O(1)
    public static Node addTwoSortedLL(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) curr.next = head1;
        if (head2 != null) curr.next = head2;

        return dummy.next;
    }

    // 🖨️ Print LL
    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // 🔹 Create Linked List
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printLL(head);

        // 🔹 Delete Middle
        head = deleteMiddleNode(head);
        System.out.println("After Deleting Middle:");
        printLL(head);

        // 🔹 Rotate by K
        head = rotateLLbyK(head, 2);
        System.out.println("After Rotation by 2:");
        printLL(head);

        // 🔹 Merge Two Lists
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);

        Node merged = addTwoSortedLL(l1, l2);
        System.out.println("Merged List:");
        printLL(merged);

        // 🔹 Create cycle manually
        Node cycleHead = new Node(1);
        cycleHead.next = new Node(2);
        cycleHead.next.next = new Node(3);
        cycleHead.next.next.next = new Node(4);

        // cycle create
        cycleHead.next.next.next.next = cycleHead.next; // 4 -> 2

        System.out.println("Cycle Exists: " + cycleExistsOrNot(cycleHead));
        System.out.println("Cycle Length: " + lengthOfLoop(cycleHead));
        System.out.println("Cycle Start: " + startNodeOfLoop(cycleHead).data);
    }
}
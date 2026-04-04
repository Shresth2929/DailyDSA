import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {

    // ---------------- ODD EVEN LINKED LIST ----------------
    // Time: O(n)
    // Space: O(1)
    // Logic: Odd index nodes ko ek list me aur even index nodes ko alag,
    // then even list ko odd ke end me attach kar dete hain
    public static Node OddEvenLinkedList(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    // ---------------- PRINT ----------------
    // Time: O(n)
    // Space: O(1)
    public static void PrintL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ---------------- SORT 0-1-2 (BRUTE) ----------------
    // Time: O(n) + O(n) = O(n)
    // Space: O(1)
    // Logic: Count number of 0,1,2 → overwrite list
    public static Node sort012Brute(Node head){
        Node temp = head;
        int c0 = 0, c1 = 0, c2 = 0;

        while(temp != null){
            if(temp.data == 0) c0++;
            else if(temp.data == 1) c1++;
            else c2++;
            temp = temp.next;
        }

        temp = head;

        while(c0-- > 0){
            temp.data = 0;
            temp = temp.next;
        }
        while(c1-- > 0){
            temp.data = 1;
            temp = temp.next;
        }
        while(c2-- > 0){
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }

    // ---------------- SORT 0-1-2 (OPTIMAL) ----------------
    // Time: O(n)
    // Space: O(1)
    // Logic: 3 dummy lists (0,1,2) banao → end me connect kar do
    public static Node sort012Optimal(Node head){

        if(head == null || head.next == null) return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node curr = head;

        while(curr != null){
            if(curr.data == 0){
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.data == 1){
                one.next = curr;
                one = one.next;
            }
            else{
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // connect lists
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    // ---------------- REMOVE NTH NODE (BRUTE) ----------------
    // Time: O(n) + O(n) = O(n)
    // Space: O(1)
    // Logic: length find karo → (len-n)th node pe jaake delete karo
    public static Node removeNthNodeBrute(Node head, int n){

        Node temp = head;
        int len = 0;

        while(temp != null){
            len++;
            temp = temp.next;
        }

        // delete head case
        if(n == len){
            return head.next;
        }

        temp = head;
        for(int i = 1; i < len - n; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    // ---------------- REMOVE NTH NODE (OPTIMAL) ----------------
    // Time: O(n)
    // Space: O(1)
    // Logic: Fast ko n steps aage bhejo → slow ko saath move karo
    // jab fast end pe ho → slow deletion ke just pehle hota hai
    public static Node removeNthNodeFromBack(Node head, int n){

        Node fast = head;
        Node slow = head;

        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        // delete head case
        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args){

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original linked list");
        PrintL(head);

        System.out.println("Odd Even linked list:");
        head = OddEvenLinkedList(head);
        PrintL(head);

        System.out.println("0-1-2 Linked List:");

        Node head2 = new Node(1);
        head2.next = new Node(0);
        head2.next.next = new Node(2);
        head2.next.next.next = new Node(1);
        head2.next.next.next.next = new Node(0);
        head2.next.next.next.next.next = new Node(2);

        PrintL(head2);

        System.out.println("sort 123 brute:");
        head2 = sort012Brute(head2);
        PrintL(head2);

        System.out.println("sort 123 optimal:");
        head2 = sort012Optimal(head2);
        PrintL(head2);

        System.out.println("remove Nth node from back:");
        head = removeNthNodeFromBack(head, 2);
        PrintL(head);
    }
}
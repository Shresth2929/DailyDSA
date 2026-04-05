import java.util.*;

class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}

public class Main {

    // ---------------- FIND MIDDLE (BRUTE) ----------------
    // Time: O(n)
    // Space: O(1)
    // Logic: length find karo → n/2 pe jao
    public static Node findMiddleNodeBrute(Node head){
        int len = 0;
        Node temp = head;

        while(temp != null){
            len++;
            temp = temp.next;
        }

        temp = head;
        for(int i = 0; i < len/2; i++){
            temp = temp.next;
        }

        return temp;
    }

    // ---------------- FIND MIDDLE (OPTIMAL) ----------------
    // Time: O(n)
    // Space: O(1)
    // Logic: slow=1 step, fast=2 step → fast end → slow middle
    public static Node findMidlNodeOptimal(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // ---------------- PRINT ----------------
    public static void printL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ---------------- PALINDROME (BRUTE) ----------------
    // Time: O(n)
    // Space: O(n)
    // Logic: list me store karo → 2 pointer se compare karo
    public static boolean checkPalindromeBrute(Node head){
        List<Integer> list = new ArrayList<>();
        Node temp = head;

        while(temp != null){
            list.add(temp.data);
            temp = temp.next;
        }

        int i = 0, j = list.size() - 1;
        while(i < j){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // ---------------- REVERSE ----------------
    // Time: O(n)
    // Space: O(1)
    public static Node reverse(Node head){
      Node curr=head;
      Node prev=null;

      while(curr !=null){
        Node next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;


      }
      return prev;

    }

    // ---------------- PALINDROME (OPTIMAL) ----------------
    // Time: O(n)
    // Space: O(1)
    // Logic:
    // 1. middle find karo
    // 2. second half reverse karo
    // 3. dono halves compare karo
    public static boolean checkPalindromeOptimal(Node head){

        if(head == null || head.next == null) return true;

        Node fast = head, slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        while(secondHalf != null){
            if(firstHalf.data != secondHalf.data){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

                // ---------------- ADD ONE ----------------
            // Time: O(n)
            // Space: O(1)
            // Logic:
            // 1. Reverse list (taaki last digit pehle aa jaye)
            // 2. Carry = 1 add karo (jaise normal addition)
            // 3. Carry propagate karo jab tak 0 na ho jaye
            // 4. Agar end pe carry bacha → new node add karo
            // 5. Reverse back to original order

            public static Node addOne(Node head){
                
                head = reverse(head);
                Node curr = head;

                int carry = 1;

                while(curr != null){   
                    int sum = curr.data + carry;
                    curr.data = sum % 10;
                    carry = sum / 10;

                    if(carry == 0) break;   // no carry → stop early

                    if(curr.next == null) break; // last node → exit loop

                    curr = curr.next;
                }

                // agar last me carry bacha
                if(carry == 1){
                    curr.next = new Node(1);
                }

                return reverse(head);
            }



            // ---------------- INTERSECTION (BRUTE) ----------------
            // Time: O(n * m)
            // Space: O(1)
            // Logic:
            // Har node of list A ko list B ke har node se compare karo
            // Agar kisi point pe reference same mila → intersection

        public static Node findIntersectionBrute(Node head1, Node head2){

                Node a = head1;

                while(a != null){
                    Node b = head2;

                    while(b != null){
                        if(a == b) return a;   // same node (address match)
                        b = b.next;
                    }

                    a = a.next;
                }

                return null;  // no intersection
            }

            // ---------------- INTERSECTION (OPTIMAL) ----------------
            // Time: O(n + m)
            // Space: O(1)
            // Logic:
            // p1 → A then B
            // p2 → B then A
            // Dono equal distance travel karte hain → intersection pe milte hain

        public static Node findIntersectionOptimal(Node head1, Node head2){

                Node p1 = head1;
                Node p2 = head2;

                while(p1 != p2){
                    p1 = (p1 == null) ? head2 : p1.next;
                    p2 = (p2 == null) ? head1 : p2.next;
                }

                return p1;  // intersection node ya null
            }

    public static void main(String[] args){

        // -------- NORMAL LIST --------
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printL(head);

        Node mid1 = findMiddleNodeBrute(head);
        System.out.println("Middle (Brute): " + mid1.data);

        Node mid2 = findMidlNodeOptimal(head);
        System.out.println("Middle (Optimal): " + mid2.data);

        // -------- PALINDROME LIST --------
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(2);
        head2.next.next.next.next = new Node(1);

        System.out.println("\nPalindrome Linked List:");
        printL(head2);

        System.out.println("Palindrome (Brute): " + checkPalindromeBrute(head2));
        System.out.println("Palindrome (Optimal): " + checkPalindromeOptimal(head2));

        System.out.println("list after adding 1");
        head=addOne(head);
        printL(head);


                // -------- COMMON PART (intersection) --------
            Node common = new Node(8);
            common.next = new Node(9);
            common.next.next = new Node(10);

            // -------- LIST A --------
            Node headA = new Node(1);
            headA.next = new Node(2);
            headA.next.next = new Node(3);
            headA.next.next.next = common;   // attach common part

            // A: 1 → 2 → 3 → 8 → 9 → 10

            // -------- LIST B --------
            Node headB = new Node(4);
            headB.next = new Node(5);
            headB.next.next = common;   // attach same common nodes

            // B: 4 → 5 → 8 → 9 → 10

            // -------- PRINT LISTS --------
            System.out.println("List A:");
            printL(headA);

            System.out.println("List B:");
            printL(headB);

            // -------- BRUTE --------
            Node inter1 = findIntersectionBrute(headA, headB);
            System.out.println("Intersection (Brute): " + 
                (inter1 != null ? inter1.data : "null"));

            // -------- OPTIMAL --------
            Node inter2 = findIntersectionOptimal(headA, headB);
            System.out.println("Intersection (Optimal): " + 
                (inter2 != null ? inter2.data : "null"));




    }
}
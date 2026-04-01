import java.lang.reflect.Array;
import java.util.*;

class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data=data;
        prev=null;
        next=null;

    }
}

public class DoublyLinkedList {

    public static void printL(Node root){
        Node temp=root;
        while(temp !=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    // Time: O(n)  -> ek baar list traverse + ek baar fill back
// Space: O(n) -> extra ArrayList use ho rahi hai ❌

    public static void reverseNaive(Node head){
        ArrayList<Integer> list = new ArrayList<>();

        Node temp = head;

        // Step 1: saare elements ArrayList me store karo
        while(temp != null){
            list.add(temp.data);
            temp = temp.next;
        }

        temp = head;

        // Step 2: reverse order me values wapas daalo
        for(int i = list.size()-1; i >= 0; i--){
            temp.data = list.get(i);
            temp = temp.next;
        }
    }

                // Time: O(n)  -> sirf ek traversal
        // Space: O(1) -> koi extra space nahi ✅

        // Logic:
        // Har node ke liye prev aur next swap karte hain
        // aur curr ko aage move karte hain using updated prev

        public static Node reverseOptimal(Node head){
            Node curr = head;
            Node temp = null;

            while(curr != null){  
                temp = curr.prev;

                // swap next and prev
                curr.prev = curr.next;
                curr.next = temp;

                // move to next node (jo pehle next tha, ab prev hai)
                curr = curr.prev;
            }

            // new head fix
            if(temp != null){
                head = temp.prev;
            }

            return head;
        }

    public static void main(String[] args) {
        Node head=new Node(4);
        Node sec=new Node(3);
        Node third=new Node(2);
        Node fourth=new Node(1);

        head.next=sec;
        head.prev=null;

        sec.next=third;
        sec.prev=head;

        third.next=fourth;
        third.prev=sec;
        

        fourth.next=null;
        fourth.prev=third;

        System.out.println("Linked list original");
        printL(head);

        reverseNaive(head);
         System.out.println("reversed using naive method :");
        printL(head);

         head=reverseOptimal(head);
         System.out.println("reversed using optimal  method :");
        printL(head);



    }
    
}

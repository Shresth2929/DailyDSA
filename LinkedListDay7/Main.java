
class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode prev;

    DoubleNode(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class Node{
    int data;

    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

public class Main {

    public static void printDLL(DoubleNode head){
    DoubleNode temp = head;

    while(temp != null){
        System.out.print(temp.data + " <-> ");
        temp = temp.next;
    }

    System.out.println("null");
}


public static void printSLL(Node head){
    Node temp = head;

    while(temp != null){
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }

    System.out.println("null");
}

    // delete all nodes whose data is same as key
    public static DoubleNode deleteAll(DoubleNode head, int key) {

        DoubleNode curr = head;

        while (curr != null) {

            if (curr.data == key) {

                // if head node
                if (curr == head) {
                    head = curr.next;
                }

                DoubleNode nextNode = curr.next;
                DoubleNode prevNode = curr.prev;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                curr = nextNode;

            } else {
                curr = curr.next;
            }
        }
        return head;
    }


    // fidn pairs with sum k
    public static void  pairSumBrute(DoubleNode head, int k){
        DoubleNode temp1=head;
        while( temp1 !=null){
            DoubleNode temp2=head;
            while( temp2 !=null){
            if(temp1.data + temp2.data ==k){
                System.out.println(temp1.data+ ","+ temp2.data);


            }
            temp2=temp2.next;

        }
        temp1=temp1.next;
    }}

    // only works if doubly linkedlist is sorted 
    public static void pairSumOptimal(DoubleNode head, int k){
        DoubleNode left=head;
        DoubleNode right=head;

        while(right.next !=null){
            right=right.next;
        }
        while ( left !=null && right.next !=left){
            int sum= left.data +right.data;
            if(sum == k){
                System.out.println(left.data+","+right.data);
                left=left.next;
                right=right.prev;

            }else if(sum <k){
                left =left.next;
            }else{
                right =right.prev;
            }
        } 
    }


    // delete all dubplicates form a sorted doubly ll
    public static DoubleNode deleteDuplicates(DoubleNode head){
    DoubleNode curr = head;

    while(curr != null && curr.next != null){
        if(curr.data == curr.next.data){
            DoubleNode nextNode = curr.next.next;

            curr.next = nextNode;
            if(nextNode != null){
                nextNode.prev = curr;
            }
        } else {
            curr = curr.next; // ✅ yahan move karna hai
        }
    }
    return head;
}


    // rotate a linked list 
    // right rotate by k
    public static Node rotateLinkedList(Node head,int k){
        if( head ==null || head.next ==null) return head;

        Node tail=head;
        int len=1;
        while(tail.next !=null){
            tail=tail.next;
            len++;
        }
        k=k % len;
        if(k==0) return head;

        tail.next=head;
        int steps=len-k;
        Node newTail=head;
        for(int i=1;i<steps;i++){
            newTail=newTail.next;
        }
        Node newHead=newTail.next;
        newTail.next=null;
        return newHead;

        
    }




    public static void main(String[] args) {

    // 🔹 Doubly Linked List: 1 <-> 2 <-> 2 <-> 3 <-> 4
    DoubleNode head = new DoubleNode(1);
    head.next = new DoubleNode(2);
    head.next.prev = head;

    head.next.next = new DoubleNode(2);
    head.next.next.prev = head.next;

    head.next.next.next = new DoubleNode(3);
    head.next.next.next.prev = head.next.next;

    head.next.next.next.next = new DoubleNode(4);
    head.next.next.next.next.prev = head.next.next.next;

    System.out.println("Original DLL:");
    printDLL(head);

    // 🔹 Delete all occurrences of 2
    head = deleteAll(head, 2);
    System.out.println("After deleting 2:");
    printDLL(head);

    // 🔹 Pair sum brute
    System.out.println("Pairs (Brute) sum = 5:");
    pairSumBrute(head, 5);

    // 🔹 Pair sum optimal (sorted list required)
    System.out.println("Pairs (Optimal) sum = 5:");
    pairSumOptimal(head, 5);

    // 🔹 Add duplicates again for testing deleteDuplicates
    head.next = new DoubleNode(3);
    head.next.prev = head;

    head.next.next = new DoubleNode(3);
    head.next.next.prev = head.next;

    System.out.println("Before removing duplicates:");
    printDLL(head);

    head = deleteDuplicates(head);
    System.out.println("After removing duplicates:");
    printDLL(head);

    // 🔹 Singly Linked List: 1 -> 2 -> 3 -> 4 -> 5
    Node head2 = new Node(1);
    head2.next = new Node(2);
    head2.next.next = new Node(3);
    head2.next.next.next = new Node(4);
    head2.next.next.next.next = new Node(5);

    System.out.println("Original SLL:");
    printSLL(head2);

    head2 = rotateLinkedList(head2, 2);

    System.out.println("After rotation by 2:");
    printSLL(head2);
}
}
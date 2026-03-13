

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

public class Main{

    public static void PrintDoublyLL(Node head){
        Node temp=head;
        while( temp !=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
    
    }

    // insertHead
    // tc: O(1)
    //  sc: O(1)
    public static Node insertAtHead(Node head,int val){
        Node newNode= new Node(val);
        if(head !=null){
            head.prev =newNode;
            newNode.next=head;
        }
        head=newNode;
        return head;
        
    }

    // insertTail
    // tc: O(n)
    //  sc: O(1)
    public static Node insertAtTail(Node head, int val){
        Node newNode = new Node(val);
        if(head==null) return newNode;

        Node temp=head;
        while(temp.next !=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;

        return head;
    }

    // insertAtK
    public static Node insertAtK(Node head, int val, int k){
        Node newNode=new Node(val);

        if(k==1){
            newNode.next=head;
            if( head !=null) head.prev=newNode;
            return newNode;
        }

        Node temp=head;
        for(int i=1;i < k-1 && temp !=null; i++){
            temp=temp.next;

        }
        if(temp ==null) return head;
        newNode.next=temp.next;
        newNode.prev=temp;

        if( temp.next !=null){
            temp.next.prev=newNode;
        }
        temp.next=newNode;
        return head;

    }


    // insert after given val
    public static Node insertAfterVal(Node head, int val, int newVal){
        Node temp=head;
        while(temp !=null && temp.data !=val){
            temp=temp.next;
        }
        if(temp==null) return head;

        Node newNode= new Node(newVal);
        newNode.next =temp.next;
        newNode.prev =temp;

        if (temp.next !=null){
            temp.next.prev=newNode;

        }
        temp.next=newNode;
        return head;
    }


    // delete head;
    // // TC: O(1)
    // SC: O(1)
    public static Node deleteHead(Node head){
        if(head == null) return null;
        if(head.next == null) return null;

        head=head.next;
        head.prev=null;

        return head;

    }

    // delete tail 
    public static Node deleteTail(Node head){
        if(head == null || head.next==null) return null;

        Node temp=head;
        while(temp.next !=null){
            temp=temp.next;
        }
        temp.prev.next=null;

        return head;

    }

    // delete kth ndoe
    public static Node deleteNodeK(Node head, int k){
        if( head == null) return null;

        if(k==1){
            head=head.next;
            if(head !=null) head.prev=null;
            return head;

        }

        Node temp=head;
        for(int i=0;i<k-1 && temp !=null;i++){
             temp=temp.next;
        }
        if(temp !=null) return head;

        if(temp.next !=null) 
            temp.next.prev=temp.prev;

        if(temp.prev !=null){
            temp.prev.next=temp.next;
        }

        return head;

    }

    // deleteby value
    public static Node deletebyVal(Node head, int val){
        if(head == null) return null;
        Node temp=head;

        while(temp !=null && temp.data !=val){
            temp=temp.next;
        }
        if(temp== null) return head;

        if(temp.prev !=null){
            temp.prev.next=temp.next;
        }
        if(temp.next !=null){
            temp.next.prev=temp.prev;
        }

        return head;
    }

    // convert array to doubly linnked list'
    public static Node arrToDoubleLL(int arr[]){
        if(arr.length ==0) return null;

        Node head=new Node(arr[0]);

        Node temp=head;
        for(int i=1; i<arr.length; i++){
            Node newNode= new Node(arr[i]);
            temp.next= newNode;
            newNode.prev = temp;

            temp=newNode;
        }
        return head;



    }


    public static void main(String[] args) {

        Node head=new Node(10);
        Node second= new Node(20);
        Node third =new Node(30);

        head.next=second;
        second.prev=head;

        second.next=third;
        third.prev=second;

        System.out.println("original doubly linked list : ");
        PrintDoublyLL(head);

        head=insertAtHead(head,150);
        System.out.println("after inserting at head : ");
        PrintDoublyLL(head);
        head=insertAtTail(head,490);
        System.out.println("after inserting at Tail : ");
        PrintDoublyLL(head);

        head=insertAtK(head,320,2);
        System.out.println("after inserting at k : ");
        PrintDoublyLL(head);
        head=insertAfterVal(head,10,760);
        System.out.println("after inserting after val : ");
        PrintDoublyLL(head);

        head=deleteHead(head);
        System.out.println("after delete head: ");
         PrintDoublyLL(head);

        head=deleteTail(head);
        System.out.println("after delete Tail: ");
         PrintDoublyLL(head);
        head=deleteNodeK(head, 3);
        System.out.println("delete node k : ");
         PrintDoublyLL(head);

        head=deletebyVal(head, 20);
        System.out.println("delete node by val : ");
         PrintDoublyLL(head);

         int arr[] = {10, 20, 30, 40, 50};

        head = arrToDoubleLL(arr);

        System.out.println("Doubly Linked List:");
        PrintDoublyLL(head);




        
    }
}
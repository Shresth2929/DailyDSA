import java.util.*;

class Node{
    int data;
    Node next ;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class LL1 {

    // Time Complexity : O(n)
    // space Complexity : O(1)
    public static int NoOfNodes(Node head){
        Node temp=head;
        int c=0;
        while(temp !=null){
            c++;
            temp=temp.next;

        }
        return c;
    }

    public static void printLL(Node head){
        Node temp=head;

        while(temp !=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }


      // Time Complexity : O(n)
    // space Complexity : O(1)
    public static boolean searchK(Node head, int k){

        Node temp=head;
        while (temp !=null ){
            if(temp.data == k){
                return true;
            }
            temp=temp.next;

        }
        return false;
    }

    // delete head 
    // Time Complexity : O(1)
    // space Complexity : O(1)
    public static Node deleteHead(Node head){
        if(head == null ) return null;

        head=head.next;
        return head;

    }

    // delete tail;
 // Time Complexity : O(n)
    // space Complexity : O(1)
    public static Node deleteTail(Node head){
        if(head == null) return null;

        Node temp=head;

        while(temp.next.next !=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }


    // delete by pos

    // // Time Complexity : O(n)
    // space Complexity : O(1)
    public static Node deletePos(Node head, int pos){
        if(head == null) return null;

        if(pos==1){
            return head.next;
        }

        Node temp=head;
        for(int i=1;i< pos-1 && temp.next !=null; i++){
            temp=temp.next;
        }
        if(temp.next !=null){
            temp.next=temp.next.next;
        }
        return head;
    }

    // delte by va;ue
    // Time Complexity : O(n)
    // space Complexity : O(1)
    public static Node deleteVal(Node head, int val){
        if(head == null) return null;

        if(head.data == val){
            return head.next;
        }

        Node temp=head;

        while(temp.next !=null && temp.next.data !=val){
            temp=temp.next;
        }
         if(temp.next !=null){
            temp.next=temp.next.next;
         }
         return head;
    }

    // insert at head;
    // Time Complexity : O(1)
    // space Complexity : O(1)
    public static Node insertHead(Node head, int val){
        Node newNode =new Node(val);
        newNode.next=head;
        head=newNode;

        return head;

    }

    // insert at tail
     // Time Complexity : O(1)
    // space Complexity : O(1)
    public static Node insertAtTail(Node head, int val){

        Node newNode= new Node(val);
        if(head ==null) return newNode;

        Node temp=head;
        while (temp.next !=null){
            temp=temp.next;
        }
        temp.next=newNode;

        return head;

    }



     // insert at pos
     // Time Complexity : O(1)
    // space Complexity : O(1)

    public static Node insertAtPos(Node head, int val,int pos){
        Node newNode= new Node(val);
        if(head== null) return newNode;

        if(pos==1){
            newNode.next=head;
            return newNode;
        }
        Node t=head;
        for(int i=1;i <pos-1 && t !=null ;i++){
            t=t.next;
        }
        if(t !=null){
           newNode.next= t.next;
           t.next=newNode;
        }

        return head;
    }


     // insert after value 
     // Time Complexity : O(1)
    // space Complexity : O(1)

    public static Node insertAfterVal(Node head, int val, int newVal){
        Node temp= head;

        while(temp !=null && temp.data !=val){
            temp=temp.next;

        }
        if(temp !=null){
            Node newNode=new Node(newVal);
            newNode.next=temp.next;
            temp.next=newNode;
        }

        return head;

    }

    public static void main(String[] args){
        Node head= new Node(10);
        head.next= new Node(20);
        head.next.next= new Node(30);

        System.out.println("Original List: ");
        printLL(head);
        System.out.println("No of nodes : "+ NoOfNodes(head));

        System.out.println("search of 30: "+searchK(head, 30));

        
        //  head = deleteHead(head);
        // System.out.println("After deleting head:");
        // printLL(head);

        // head=deleteTail(head);
        // System.out.println("after deleting tail:");
        // printLL(head);

        // head=deletePos(head, 2);
        // System.out.println("after deleting pos:");
        // printLL(head);

        head=deleteVal(head, 20);
        System.out.println("after deleting val:");
         printLL(head);
         
        head= insertHead(head, 50);
        System.out.println("after adding at head:");
         printLL(head);
        head= insertAtTail(head, 100);
        System.out.println("after adding at tail:");
         printLL(head);
        head= insertAtPos(head, 70, 4);
        System.out.println("after adding at pos:");
         printLL(head);
        head= insertAfterVal(head, 70, 90);
        System.out.println("adding after val:");
         printLL(head);
         









    }

    
}
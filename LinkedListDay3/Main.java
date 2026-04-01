import java.util.*;


class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
    
}



public class Main {

    public static void printL(Node root){
        Node temp=root;
        while(temp !=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }


    // Time: O(n)
// Space: O(n) ❌ (extra memory)
    public static void reverseNaive(Node root){
        ArrayList<Integer> list=new ArrayList<>();

        Node temp=root;
        while(temp !=null){
            list.add(temp.data);
            temp=temp.next;
        }
        temp=root;
        for(int i=list.size() -1; i>=0; i--){
            temp.data=list.get(i);
            temp=temp.next;
        }
    }



//     Time: O(n)
// Space: O(1) ✅ (best)

    public static Node reverseOptimal(Node head){
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

    public static Node addTwoList(Node l1,Node l2){
        Node dummyNode=new Node(0);
        Node curr=dummyNode;

        int carry=0;
        while(l1 !=null || l2!=null || carry !=0){
            int sum=carry;
            if(l1 !=null){
                sum +=l1.data;
                l1=l1.next;
            }
            if(l2 !=null){
                sum +=l2.data;
                l2=l2.next;
            }

            carry=sum/10;
            int digit=sum %10;

            curr.next=new Node(digit);
            curr=curr.next;
        }

        return dummyNode.next;


    }

    public static void main(String[] args){
        Node head=new Node(4);
        head.next=new Node(3);
        head.next.next=new Node(2);
        head.next.next.next=new Node(1);

        System.out.println("Linked list original");
        printL(head);

        reverseNaive(head);
         System.out.println("reversed linked list by naive method P");
        printL(head);

       head= reverseOptimal(head);
         System.out.println("reversed linked list by Optimal method P");
        printL(head);

       
         System.out.println("adding two loinked list");
         head=addTwoList(head, head);
        printL(head);




    }
    
}

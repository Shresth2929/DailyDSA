import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }

}

class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class traversals {

    // level order traversal : BFS

    // Level Order traversal me hum:

// Queue use karte hain because it uses fifo 
// Root ko queue me daalte hain
// Jab tak queue empty nahi hoti:
// Front element nikalo
// Print karo
// Uske left aur right children queue me daalo

public static void levelOrder(Node root){
        if(root == null) return ;

        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(! q.isEmpty()){
            Node current= q.poll();
            System.out.print(current.data+" ");

            if(current.left  !=null){
                q.add(current.left);
            }
            if(current.right !=null){
                q.add(current.right);
            }
        }



    }

    public static void iterativePreorder(Node root){
        if(root== null) return ;

        Stack<Node> stack=new Stack<>();
        stack.push(root);

        while(! stack.isEmpty()){
            Node current=stack.pop();

            System.out.print(current.data+" ");

            if(current.right !=null){
                stack.push(current.right);
            }
            if(current.left !=null){
                stack.push(current.left);
            }
        }
    }


    // iterative inorder

    public static void iterativeInorder(Node root){
        if(root == null) return ;

        Stack<Node> stack = new Stack<>();
        Node current=root;

        while(current !=null || !stack.isEmpty()){

            while(current !=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();
            System.out.print(current.data +" ");
            current=current.right;

        }
    }


    public static void iterativePostorder2stack(Node root){
        Stack<Node> stack1= new Stack<>();
        Stack<Node> stack2= new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            Node current=stack1.pop();

            stack2.push(current);

            if(current.left !=null){
                stack1.push(current.left);
            }
            if(current.right !=null){
                stack1.push(current.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+" ");
        }
        


    }

    public static void iterativePostorder1stack(Node root){
        if(root == null) return ;

        Stack<Node> stack = new Stack<>();
        Node current=root;
        Node visited=null;

        while(current !=null || !stack.isEmpty()){
            if (current !=null){
                stack.push(current);
                current=current.left;
            }
            else{
                Node peekNode=stack.peek();
                if(peekNode.right !=null && visited !=peekNode.right){
                    current=peekNode.right;

                }else{
                    System.out.print(peekNode.data +" ");
                    visited=stack.pop();
                }
            }
        }

    }

    public static void allIterations(Node root){
        if(root == null) return ;

        Stack<Pair>stack=new Stack<>();

        List<Integer> preOrder=new ArrayList<>();
        List<Integer> inOrder= new ArrayList<>();
        List<Integer> postOrder=new ArrayList<>();

        stack.push(new Pair(root,1));
        while(!stack.isEmpty()){
            Pair top=stack.pop();
            if(top.state ==1){
                preOrder.add(top.node.data);
                top.state++;
                stack.push(top);

                if(top.node.left !=null){
                    stack.push(new Pair(top.node.left,1));
                }
            }else if(top.state==2){
                inOrder.add(top.node.data);
                top.state++;
                stack.push(top);

                if(top.node.right !=null){
                  
                    stack.push(new Pair(top.node.right,1));

                }
            }else{
                postOrder.add(top.node.data);
            }
        }
        System.out.println("preorder: "+preOrder);
        System.out.println("inorder: "+inOrder);
        System.out.println("postorder: "+postOrder);
    }




    public static  void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);

        System.out.println("levelorder traversal: ");
        levelOrder(root);
        System.out.println();

        System.out.println("iterative pre order : ");
        iterativePreorder(root);
        System.out.println();

        System.out.println("iterative in order : ");
        iterativeInorder(root);
        System.out.println();

        System.out.println("iterative postorder using 2 stack: ");
        iterativePostorder2stack(root);
        System.out.println();

        System.out.println("iterative postorder using 1 stack: ");
        iterativePostorder1stack(root);
        System.out.println();

        System.out.println("all using one stack: ");
        allIterations(root);
        System.out.println();

    }
    
}

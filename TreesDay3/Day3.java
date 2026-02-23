

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data ){
        this.data=data;
        left=null;
        right=null;
    } 
}

class Pair{
    Node node;
    int hd;

    Pair(Node node, int hd){
        this.node=node;
        this.hd=hd;
    }
}

public class Day3 {

    // zigzag traversal
    // time: O(n) space: O(n)

    public static List<List<Integer>> zigzag(Node root){
        List<List<Integer>> result= new ArrayList<>();
        if(root == null) return result;

        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);

        boolean leftToRight=true;

        while(!queue.isEmpty()){
            int size=queue.size();
            LinkedList<Integer> list=new LinkedList<>();

            for(int i=0;i<size;i++){
                Node curr=queue.poll();

                if(leftToRight){
                    list.addLast(curr.data);
                }else{
                    list.addFirst(curr.data);
                }
                    if(curr.left != null) queue.offer(curr.left);
                    if(curr.right !=null) queue.offer(curr.right);
                }
                result.add(list);
                leftToRight= !leftToRight;
            }
            return result;
        }

    // boundry traversal
    // time: O(n) space: O(h)
    public static boolean isLeafNode(Node root){
        return  root.left ==null && root.right ==null;
            
        
    }
    public static void addLeftBoundar(Node root, List<Integer> list){
        Node curr=root.left;
        while (curr !=null){
            if(!isLeafNode(curr)) list.add(curr.data);
            if(curr.left !=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    public static void addLeaves(Node root, List<Integer> list){
        if(isLeafNode(root)){
            list.add(root.data);
            return;
        }
        if(root.left !=null)  addLeaves(root.left, list);
        if(root.right !=null) addLeaves(root.right, list);
    }

    public static void addRightBoundary(Node root, List<Integer> list){
        Node curr=root.right;
        Stack<Integer> stack=new Stack<>();

        while (curr !=null){
            if(!isLeafNode(curr)) stack.push(curr.data);
            if(curr.right !=null) curr=curr.right;
            else curr=curr.left;

        }
        while (! stack.isEmpty()) list.add(stack.pop());
     }

     public static List<Integer > boundaryTraversal(Node root){
        List<Integer> list =new ArrayList<>();
        if(root == null) return list;

        if(!isLeafNode(root)) list.add(root.data);
        addLeftBoundar(root, list);
        addLeaves(root, list);
        addRightBoundary(root, list);

        return list;
     }

    //  vertical order traversal
    // time: O(n log n)  space : O(n)
    public static List<List<Integer>> verticalOrder(Node root){
        List<List<Integer>> result=new ArrayList<>();
        if(root== null) return result;

        TreeMap<Integer, List<Integer>> treeMap=new TreeMap<>();

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            Node curr=temp.node;
            int hd=temp.hd;

            treeMap.putIfAbsent(hd, new ArrayList<>());
            treeMap.get(hd).add(curr.data);

            if(curr.left !=null){
                q.offer(new Pair(curr.left,hd-1));
            }
            if(curr.right !=null){
                q.offer(new Pair(curr.right, hd+1));
            }
        }
            for(List<Integer> list : treeMap.values()){
                result.add(list);
            
        }
        return result;
    }

    

    public static void main(String[] args) {
        
        Node root=new  Node(1);
        root.left= new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);

        System.out.println("zigzag trsversal: ");
        System.out.println(zigzag(root));

        System.out.println("boundary trsversal: ");
        System.out.println(boundaryTraversal(root));

        System.out.println("vertical order  traversal: ");
        System.out.println(verticalOrder(root));

    }
    
}

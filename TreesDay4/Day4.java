

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

class Pair{
    Node node;
    int hd;

    Pair(Node node, int hd){
        this.node=node;
        this.hd=hd;
    }

}

public class Day4 {

    // top view

    public static  List<Integer> topViewBT(Node root){
        List<Integer> result=new ArrayList<>();
        if(root == null) return result;

        TreeMap<Integer, Integer> map=new TreeMap<>();



        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair temp = q.poll();
            Node curr=temp.node;
            int hd= temp.hd;

            if(!map.containsKey(hd)){
                map.put(hd, curr.data);
            }
            if(curr.left !=null){
                q.offer(new Pair(curr.left, hd-1));
            }
            if(curr.right !=null ){
                q.offer(new Pair(curr.right , hd+1));
            }
        }
            for(int val : map.values()){
                result.add(val);
            }
            return result;
    
    }

    // bottom view 

    public static List<Integer> bottomViewBT(Node root){
        List<Integer> result=new ArrayList<>();
        if(root == null) return result;

        TreeMap<Integer, Integer> map=new TreeMap<>();

        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            Node curr=temp.node;
            int hd= temp.hd;
            
            map.put(hd, curr.data);

            if(curr.left !=null){
                queue.add(new Pair(curr.left, hd-1));

            }
            if(curr.right !=null){
                queue.add(new Pair(curr.right, hd+1));
            }
        }
            for(int val : map.values()){
                result.add(val);
            }
        
        return result;

    
    }


    // left view 
    public static List<Integer> leftView(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;


        Queue<Node > q= new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){

            int size= q.size();

            for(int i=0;i<size;i++){
            Node curr=q.poll();
            if(i ==0 ) ans.add(curr.data);

            if(curr.left !=null) q.offer(curr.left);
            if(curr.right !=null) q.offer(curr.right);

            }

        }

return  ans ;
    }

    // right view 
    public static List<Integer> rightView(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node > q= new LinkedList<>();
        q.offer(root);
        while(! q.isEmpty()){
            int size= q.size();

            for(int i=0;i<size;i++){
                Node curr= q.poll();

                if(i==size-1) ans.add(curr.data);

                if(curr.left !=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);


            }
        }
        return ans;
    }

    // symmetric or not 

    public static boolean isSymmetric(Node root){
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(Node a, Node b){
        if(a==null && b== null) return true;
        if(a== null || b==null) return false;

        return (a.data == b.data ) && isMirror(a.left, b.left) && isMirror(a.right, b.right);
    }


    public static void main(String[] args){
        Node root=new  Node(1);
        root.left= new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);

        System.out.println("top view : ");
        System.out.println(topViewBT(root));

        System.out.println("bottom view : ");
        System.out.println(bottomViewBT(root));

        System.out.println("left view : ");
        System.out.println(leftView(root));

        System.out.println("right view : ");
        System.out.println(rightView(root));

        System.out.println("is symmetric  or not : ");
        System.out.println(isSymmetric(root));

        
    }
    
}

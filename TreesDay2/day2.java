
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data =data;
        left=null;
        right=null;
    }
}

public class day2 {

    // max depth of binary tree 
    // tc : O(n)  sc: O(h)
    public static int maxDepth(Node root ){
        if(root == null ) return 0;

        int left=maxDepth(root.left);
        int  right =maxDepth(root.right);

        return 1+ Math.max(left,right);
    }



    // check whether tree is balanced or not
    // time: O(n)        space : O(h)

    public static int giveHeight(Node root){
        if(root == null) return 0;

        int left=giveHeight(root.left);
        if(left == -1) return -1;

        int right =giveHeight(root.right);
        if(right ==-1) return -1;


        if(Math.abs(left - right ) >1) return -1;
        return 1+Math.max(left,right);
    }

    public static boolean checkBalanced(Node root){
        return giveHeight(root) !=-1;
    }

    // diameter of a binary tree 
    // time: O(n)  height: O(h)

    static int diameter=0;
    public static int height(Node root ){
        if(root == null) return 0;

        int left=height(root.left);
        int right = height (root.right);

        diameter = Math.max(diameter, left+right);
        return 1+ Math.max(left,right);
    }
    public static int diameterBinaryTree(Node root){
        diameter=0;
        height(root);
        return diameter;
    }

    // find max path sum
    // time: O(n) spacce: O(h)

    static int sum= Integer.MIN_VALUE;
    public static int maxGain(Node root){
        if(root == null) return 0;

        int left=Math.max(0, maxGain(root.left));
        int right= Math.max(0, maxGain(root.right));
        
        int currentPath= left+right +root.data;

        sum=Math.max(sum,currentPath);
        return root.data +Math.max(left,right);


    }
    public static int maxPathSum(Node root){
        sum =Integer.MIN_VALUE;
        maxGain(root);
        return sum;
    }

    // check whether smae tree of not
    // time:o(n)   space: o(h)  

    public static boolean sameOrNot(Node p, Node q){
        if(p== null && q== null) return true;

        if( p==null || q==null) return false;

        if(p.data != q.data) return false;

        return sameOrNot(p.left, q.left) && sameOrNot(p.right, q.right);
    }
    
    public static void main(String[] agrs){
        Node root=new  Node(1);
        root.left= new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);


        System.out.print("max depth: ");
        System.out.println(maxDepth(root));

        System.out.print("checking whther balanced or not :");
        System.out.println(checkBalanced(root));
        System.out.print("diameter : ");
        System.out.println(diameterBinaryTree(root));

        System.out.print("max path sum : ");
        System.out.println(maxPathSum(root));
        
        System.out.print("is same tree or not : ");
        System.out.println(sameOrNot(root, root));


    }

    
}

import java.util.ArrayList;

public class Balanced_BST{
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;

        }
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void grtInorder(Node root,ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        grtInorder(root.left, inorder);
        inorder.add(root.data);
        grtInorder(root.right, inorder);

    }
    public static Node CreateBST(ArrayList<Integer> inorder.int st,int end){
        int mid =(st+end)/2;
        Node root =new Node(inorder.get(mid));
         root.left =CreateBST(inorder,st,mid-1);
        root.right =CreateBST(inorder,mid+1,end);
        return root; 
    }
    public static Node balancedBST(Node root){
        ArrayList<Integer> inorder = new ArrayList<>();
        grtInorder(root, inorder);
        root = public static void main(String[] args) {
        /*
         *          8
         *         / \
         *       6    10 
         *      /        \
         *     5          11
         *    /             \
         *   3              12
         * 
         */
        Node root = new Node (8);
        root.left =new Node(6);
        root.left.left=new Node (5);
        root.left.left.left = new Node(3);

        root.right= new Node(10);
        root.right.right= new Node(11);
        root.right.right= new Node(12);

    }
    
}
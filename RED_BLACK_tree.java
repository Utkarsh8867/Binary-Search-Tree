/**
 * RED_BLACK_tree
 */
public class RED_BLACK_tree {

    public Node root;//root node
     public RED_BLACK_tree() {
      super();
      root = null;
   
  }
  class Node {
    int data;
    Node left;
    Node right;
    char colour;
    Node parent;
    Node(int data) {
    super();
    this.data = data; // only including data. not key
    this.left = null; // left subtree
    this.right = null; // right subtree
    this.colour = 'R'; // colour . either 'R' or 'B'
    this.parent = null; // required at time of rechecking.
    }
    }
    Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x; // parent resetting is also important.
        if(y!=null)
        y.parent = node;
        return(x);
        }
        Node rotateRight(Node node) {
            Node x = node.left;
            Node y = x.right;
            x.right = node;
            node.left = y;
            node.parent = x;
            if(y!=null)
            y.parent = node;
            return(x);
            }
            // these are some flags.
// Respective rotations are performed during traceback.
// rotations are done if flags are true.
boolean ll = false;
boolean rr = false;
boolean lr = false;
boolean rl = false;
// helper function for insertion. Actually this function performs all tasks insingle pass only.
Node insertHelp(Node root, int data) {
// f is true when RED RED conflict is there.
boolean f=false;
//recursive calls to insert at proper position according to BST properties.
if(root==null)
return(new Node(data));
else if(data<root.data) {

    root.left = insertHelp(root.left, data);
    root.left.parent = root;
    if(root!=this.root) {
    if(root.colour=='R' && root.left.colour=='R')
    f = true;
    }
    }
    else {
    root.right = insertHelp(root.right,data);
    root.right.parent = root;
    if(root!=this.root) {
    if(root.colour=='R' && root.right.colour=='R')
    f = true;
    }
    // at the same time of insertion, we are also assigning parent nodes
    // also we are checking for RED RED conflicts
    }
    if(this.ll) {
        root = rotateLeft(root);
        root.colour = 'B';
        root.left.colour = 'R';
        this.ll = false;
        }
        else if(this.rr) {
        root = rotateRight(root);
        root.colour = 'B';
        root.right.colour = 'R';
        this.rr = false;
        }
        else if(this.rl) {
        root.right = rotateRight(root.right);
        root.right.parent = root;
        root = rotateLeft(root);
        root.colour = 'B';
        root.left.colour = 'R';
        this.rl = false;
        }
        // abhaykumar.gv@gmail.com
        else if(this.lr) {
        root.left = rotateLeft(root.left);
        root.left.parent = root;
        root = rotateRight(root);
        root.colour = 'B';
        root.right.colour = 'R';
        this.lr = false;
        }
        // when rotation and recolouring is done flags are reset.
// Now lets take care of RED RED conflict
if(f) {
    // to check which child is the current node of its parent
    if(root.parent.right == root) {
    // case when parent's sibling is black
    if(root.parent.left==null || root.parent.left.colour=='B') {//
    // perform certaing rotation and recolouring. This will be done while backtracking.
    // Hence setting up respective flags.
    if(root.left!=null && root.left.colour=='R')
    this.rl = true;
    else if(root.right!=null && root.right.colour=='R')
    this.ll = true;
    }
    // case when parent's sibling is red
    else {
    root.parent.left.colour = 'B';
    root.colour = 'B';
    if(root.parent!=this.root)
    root.parent.colour = 'R';
    }
    }
    else {
    if(root.parent.right==null || root.parent.right.colour=='B') {
    if(root.left!=null && root.left.colour=='R')
    this.rr = true;
    else if(root.right!=null && root.right.colour=='R')
    this.lr = true;
    }
    else {
    root.parent.right.colour = 'B';
    root.colour = 'B';
    // abhaykumar.gv@gmail.com
    if(root.parent!=this.root)
    root.parent.colour = 'R';
    }
    }
    f = false;
}
return(root);
}
// function to insert data into tree.
public void insert(int data) {
if(this.root==null) {
this.root = new Node(data);
this.root.colour = 'B';
}
else
this.root = insertHelp(this.root,data);
}
// helper function to print inorder traversal
void inorderTraversalHelper(Node node) {
if(node!=null) {
inorderTraversalHelper(node.left);
System.out.printf("%d ", node.data);
inorderTraversalHelper(node.right);
}
}
//function to print inorder traversal
public void inorderTraversal() {
inorderTraversalHelper(this.root);
}
// helper function to print the tree.
void printTreeHelper(Node root, int space) {
int i;
if(root != null) {
space = space + 10;
printTreeHelper(root.right, space);
System.out.printf("\n");
for ( i = 10; i < space; i++) {
System.out.printf(" ");
}
System.out.printf("%d", root.data);
System.out.printf("\n");
printTreeHelper(root.left, space);
}
}
// function to print the tree.
public void printTree() {
printTreeHelper
(this.root,0);}
public static void main
(String[] args) {
RED_BLACK_tree t= new RED_BLACK_tree();
int[] arr = {
1,4,6,3,5,7,8,2,9};
for(int i=0;i<9;i++) {t.insert(arr[i]);
    System.out.println();
    t.inorderTraversal();}
    t.printTree();
}
}

    
// }
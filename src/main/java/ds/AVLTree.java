package ds;



//Java program for insertion in AVL Tree
class Node {
 int key, height;
 Node left, right;

 Node(int d) {
     key = d;
     height = 1;
 }
}

public class AVLTree {
 Node root;

 // A utility function to get height of the tree
 int height(Node n) {
     if (n == null)
         return 0;

     return n.height;
 }

 // A utility function to get maximum of two integers
 int max(int a, int b) {
     return (a > b) ? a : b;
 }

 // A utility function to right rotate subtree rooted with y
 // See the diagram given above.
 /*
  * a) Left Left Case

  T1, T2, T3 and T4 are subtrees.
         z                                      y 
        / \                                   /   \
       y   T4      Right Rotate (z)          x      z
      / \          - - - - - - - - ->      /  \    /  \ 
     x   T3                               T1  T2  T3  T4
    / \
  T1   T2
  */
 Node rightRotate(Node z) {
	   	Node y = z.left;
	    Node T3 = y.right;

	     // Perform rotation
	    y.right = z;
	    z.left = T3;

	     // Update heights
	    z.height = max(height(z.left), height(z.right)) + 1; 
	    y.height = max(height(y.left), height(y.right)) + 1;

	     // Return new root
	     return y;
 }

 // A utility function to left rotate subtree rooted with x
 // See the diagram given above.
 Node leftRotate(Node x) {
     Node y = x.right;
     Node T2 = y.left;

     // Perform rotation
     y.left = x;
     x.right = T2;

     //  Update heights
     x.height = max(height(x.left), height(x.right)) + 1;
     y.height = max(height(y.left), height(y.right)) + 1;

     // Return new root
     return y;
 }

 // Get Balance factor of node N
 int getBalance(Node N) {
     if (N == null)
         return 0;

     return height(N.left) - height(N.right);
 }

 Node insert(Node node, int key) {

     /* 1.  Perform the normal BST insertion */
     if (node == null)
         return (new Node(key));

     if (key < node.key)
         node.left = insert(node.left, key);
     else if (key > node.key)
         node.right = insert(node.right, key);
     else // Duplicate keys not allowed
         return node;

     /* 2. Update height of this ancestor node */
     node.height = 1 + max(height(node.left),
                           height(node.right));

     /* 3. Get the balance factor of this ancestor
           node to check whether this node became
           unbalanced */
     int balance = getBalance(node);

     // If this node becomes unbalanced, then there
     // are 4 cases Left Left Case
     if (balance > 1 && key < node.left.key)
         return rightRotate(node);

     // Right Right Case
     if (balance < -1 && key > node.right.key)
         return leftRotate(node);

     // Left Right Case
     if (balance > 1 && key > node.left.key) {
         node.left = leftRotate(node.left);
         return rightRotate(node);
     }

     // Right Left Case
     if (balance < -1 && key < node.right.key) {
         node.right = rightRotate(node.right);
         return leftRotate(node);
     }

     /* return the (unchanged) node pointer */
     return node;
 }

 // A utility function to print preorder traversal
 // of the tree.
 // The function also prints height of every node
 void preOrder(Node node) {
     if (node != null) {
         System.out.print(node.key + " ");
         preOrder(node.left);
         preOrder(node.right);
     }
 }

 // A utility function to print preorder traversal
 // of the tree.
 // The function also prints height of every node
 void inOrder(Node node) {
     if (node != null) {
    	 inOrder(node.left);
         System.out.print(node.key + " ");
         inOrder(node.right);
     }
 }
 
 public static void main(String[] args) {
     AVLTree tree = new AVLTree();

     /* Constructing tree given in the above figure */
     tree.root = tree.insert(tree.root, 10);
     tree.root = tree.insert(tree.root, 20);
     tree.root = tree.insert(tree.root, 30);
     tree.root = tree.insert(tree.root, 40);
     tree.root = tree.insert(tree.root, 50);
     tree.root = tree.insert(tree.root, 25);

     /* The constructed AVL Tree would be
          30
         /  \
       20   40
      /  \     \
     10  25    50
     */
     System.out.println("Preorder traversal" +
                     " of constructed tree is : ");
     tree.preOrder(tree.root);
     
     System.out.println("Inorder traversal" +
             " of constructed tree is : ");
     tree.inOrder(tree.root);
 }
}

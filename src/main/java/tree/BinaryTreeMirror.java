package tree;

//Java program for different tree traversals

class BinaryTreeMirror
{
 // Root of Binary Tree
 Node root;

 BinaryTreeMirror()
 {
     root = null;
 }

 /* Given a binary tree, print its nodes according to the
   "bottom-up" postorder traversal. */
 Node mirror(Node node)
 {
     if (node == null)
     {
    	 return null;
     }

     // first recur on left subtree
     Node left = mirror(node.left);
     Node right = mirror(node.right);
     
     node.left = right;
     node.right = left;
     
     return node;
 }

 /* Given a binary tree, print its nodes in inorder*/
 void printInorder(Node node)
 {
     if (node == null)
         return;

     /* first recur on left child */
     printInorder(node.left);

     /* then print the data of node */
     System.out.print(node.data + " ");

     /* now recur on right child */
     printInorder(node.right);
 }


 // Wrappers over above recursive functions
 void printInorder()    {     printInorder(root);   }

 // Driver method
 public static void main(String[] args)
 {
     BinaryTreeMirror tree = new BinaryTreeMirror();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);

     System.out.println("\nInorder traversal of binary tree is: ");
     tree.printInorder();

     /* convert tree to its mirror */
     tree.mirror(tree.root);

     /* print inorder traversal of the minor tree */
     System.out.println("\nInorder traversal of Mirror binary tree is : ");
     tree.printInorder();
 }
}
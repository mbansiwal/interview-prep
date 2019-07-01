package tree;

//Java program for different tree traversals

class BinaryTreeLowestCommonAncestor
{
 // Root of Binary Tree
 Node root;

 BinaryTreeLowestCommonAncestor()
 {
     root = null;
 }

 public Node lcaBinaryTree(Node root, Node n1, Node n2){
     if(root == null){
         return null;
     }
     if(root == n1 || root == n2){
         return root;
     }
     
     Node left = lcaBinaryTree(root.left, n1, n2);
     Node right = lcaBinaryTree(root.right, n1, n2);

     if(left != null && right != null){
         return root;
     }
     return left != null ? left : right;
 }
 
 /* Given a binary tree, print its nodes according to the
   "bottom-up" postorder traversal. */
 Node lcaBinarySearchTree(Node node,int n1, int n2)
 {
     if (node == null)
     {
    	 return null;
     }

     if(node.data > n1 && node.data > n2)
     {
    	return lcaBinarySearchTree(node.left, n1, n2);
     }
     else if(node.data < n1 && node.data < n2)
     {
    	return lcaBinarySearchTree(node.right, n1, n2);
     }
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
     BinaryTreeLowestCommonAncestor tree = new BinaryTreeLowestCommonAncestor();
     tree.root = new Node(20);
     tree.root.left = new Node(8);
     tree.root.right = new Node(22);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(12);
     tree.root.left.right.left = new Node(10);
     tree.root.left.right.right = new Node(14);

     int n1 = 10, n2 = 14;
     Node t = tree.lcaBinarySearchTree(tree.root, n1, n2);
     System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
     
     t = tree.lca2(tree.root, n1, n2);
     System.out.println("LCA2 of " + n1 + " and " + n2 + " is " + t.data);

     n1 = 14;
     n2 = 8;
     t = tree.lcaBinarySearchTree(tree.root, n1, n2);
     System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

     n1 = 10;
     n2 = 22;
     t = tree.lcaBinarySearchTree(tree.root, n1, n2);
     System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
 }
 
 Node lca2(Node node,int n1, int n2)
 {
	 if(node == null)
	 {
		 return null;
	 }
	 
	 if(node.data > n1 && node.data > n2)
	 {
		 return lca2(node.left, n1, n2);
	 }
	 else if(node.data < n1 && node.data < n2)
	 {
		 return lca2(node.right, n1, n2);
	 }
	 return node;
 }
}
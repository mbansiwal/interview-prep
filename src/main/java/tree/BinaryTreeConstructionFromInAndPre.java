package tree;

public class BinaryTreeConstructionFromInAndPre {
	// Root of Binary Tree
	 Node root;
	 int preIndex = 0;
	 
	 BinaryTreeConstructionFromInAndPre()
	 {
	     root = null;
	 }
	 
	 Node buildTree(int in[], int pre[], int inStart, int inEnd)
	 {
		 if(inStart > inEnd)
		 {
			 return null;
		 }
		 else
		 {
			 Node node = new Node(pre[preIndex++]);
			 if(inStart == inEnd)
			 {
				 return node;
			 }
			 else
			 {
				 int inIndex = search(in, node.data, inStart, inEnd);
				 node.left = buildTree(in, pre, inStart, inIndex-1);
				 node.right = buildTree(in, pre, inIndex+1, inEnd);
			 }
			 return node;
		 }
	 }
	 
	 int search(int[] in, int node, int inStart, int inEnd)
	 {
		 int i=inStart;
		 for (;i <= inEnd; ++i)
		 {
			if(in[i] == node)
			{
				return i;
			}
		}
		 return i;
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
		 BinaryTreeConstructionFromInAndPre tree = new BinaryTreeConstructionFromInAndPre();
        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);
  
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
	 }
}

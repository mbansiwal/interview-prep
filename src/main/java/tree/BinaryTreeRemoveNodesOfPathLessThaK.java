package tree;

public class BinaryTreeRemoveNodesOfPathLessThaK {
	 Node root;

	Node prune3(Node node, int sum)
	{
		if (node == null)
		{
			return null;
		}

		node.left = prune3(node.left, sum - node.data);
		node.right = prune3(node.right, sum - node.data);

		if (node.left == null && node.right == null)
		{
			if (sum > node.data)
			{
				return null;
			}
		}

		return node;
	}

	    /* Compute the "maxDepth" of a tree -- the number of 
	       nodes along the longest path from the root node 
	       down to the farthest leaf node.*/
	 Node prune(Node root, int sum)
	 {
	     // Base Case
	     if (root == null) return null;
	  
	     // Recur for left and right subtrees
	     root.left = prune(root.left, sum - root.data);
	     root.right = prune(root.right, sum - root.data);
	  
	     // If we reach leaf whose data is smaller than sum,
	     // we delete the leaf.  An important thing to note
	     // is a non-leaf node can become leaf when its
	     // chilren are deleted.
		if (root.left == null && root.right == null && root.data < sum)
	     {
	             return null;
	     }
	  
	     return root;
	 }
	 
	 
	 Node prune2(Node root, int sum)
	 {
		 if(root == null)
		 {
			 return null;
		 }
		 
		 root.left = prune2(root.left, sum-root.data);
		 root.right = prune2(root.right, sum-root.data);
		 
		 if(root.left == null && root.right == null)
		 {
			 if(sum > root.data)
			 {
				 return null;
			 }
		 }
		 
		 return root;
	 }
	 
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
	 
	    /* Driver program to test above functions */
	    public static void main(String[] args) 
	    {
	    	BinaryTreeRemoveNodesOfPathLessThaK tree = new BinaryTreeRemoveNodesOfPathLessThaK();
	    	tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(6);
	        tree.root.right.right = new Node(7);
	        tree.root.left.left.left = new Node(8);
	        tree.root.left.left.right = new Node(9);
	        tree.root.left.right.left = new Node(12);
	        tree.root.right.right.left = new Node(10);
	        tree.root.right.right.left.right = new Node(11);
	        tree.root.left.left.right.left = new Node(13);
	        tree.root.left.left.right.right = new Node(14);
	        tree.root.left.left.right.right.left = new Node(15);
	  
	        System.out.println("Tree before truncation\n");
	        tree.printInorder(tree.root);
	     
	        tree.root = tree.prune2(tree.root, 45); // k is 45
	     
	        System.out.println("\n\nTree after truncation\n");
	        tree.printInorder(tree.root);
	    }
}

package tree;

public class BinaryTreeDiameterOrBreadth {
	 Node root;
	  
	    /* Compute the "maxDepth" of a tree -- the number of 
	       nodes along the longest path from the root node 
	       down to the farthest leaf node.*/
	    int maxDepth(Node node) 
	    {
	        if (node == null)
	            return 0;
	        else
	        {
	            /* compute the depth of each subtree */
	            int lDepth = maxDepth(node.left);
	            int rDepth = maxDepth(node.right);
	  
	            return 1+Math.max(lDepth, rDepth);
	        }
	    }
	    
	    int diameter(Node node) 
	    {
	        if (node == null)
	        {
	        	return 0;
	        }
	        else
	        {
	            int lHeight = maxDepth(node.left);
	            int rHeight = maxDepth(node.right);
	        	/* compute the depth of each subtree */
	            int lDiameter = diameter(node.left);
	            int rDiameter = diameter(node.right);
	            int diameter = Math.max(lDiameter, rDiameter);
	            return Math.max(diameter , 1 + lHeight + rHeight);
	        }
	    }
	      
	    /* Driver program to test above functions */
	    public static void main(String[] args) 
	    {
	    	BinaryTreeDiameterOrBreadth tree = new BinaryTreeDiameterOrBreadth();
	  
	    	tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	 
	        System.out.println("The diameter of given binary tree is : "
	                           + tree.diameter(tree.root));
	    }
}

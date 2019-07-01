package tree;

/**
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present 
 * in its left subtree and right subtree
 */
public class BinarySumTree {
	 Node root;
	  
	    /* Utility function to check if the given node is leaf or not */
	    boolean isLeaf(Node node) 
	    {
	        return (node.left==null && node.right == null);
	    }
	  
	    /* returns 1 if SumTree property holds for the given
	       tree */
	    boolean isSumTree(Node node) 
	    {
	        int ls; // for sum of nodes in left subtree
	        int rs; // for sum of nodes in right subtree
	        
	        if(node == null || isLeaf(node))
	        {
	        	return true;
	        }
	        if(isSumTree(node.left) && isSumTree(node.right))
	        {
	        	if(node.left == null)
	        	{
	        		ls = 0;
	        	}
	        	else if(isLeaf(node.left))
	        	{
	        		ls = node.left.data;
	        	}
	        	else
	        	{
	        		ls = 2 * node.left.data;
	        	}
	        	
	        	if(node.right == null)
	        	{
	        		rs = 0;
	        	}
	        	else if(isLeaf(node.right))
	        	{
	        		rs = node.right.data;
	        	}
	        	else
	        	{
	        		rs = 2 * node.right.data;
	        	}
	        	
	        	int sum = ls + rs;
	        	
	        	return node.data == sum;
	        }
	        
	        return false;
	    }
	    
	    public static void main(String args[]) 
	    {
	        BinarySumTree tree = new BinarySumTree();
	        tree.root = new Node(26);
	        tree.root.left = new Node(10);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(6);
	        tree.root.right.right = new Node(3);
	  
	        if (tree.isSumTree(tree.root))
	            System.out.println("The given tree is a sum tree");
	        else
	            System.out.println("The given tree is not a sum tree");
	    }
}

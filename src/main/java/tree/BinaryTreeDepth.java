package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDepth {
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
	    
	    int minDepth(Node node) 
	    {
	        if (node == null)
	            return 0;
	        else
	        {
	            /* compute the depth of each subtree */
	            int lDepth = minDepth(node.left);
	            int rDepth = minDepth(node.right);
	  
	            return 1+Math.min(lDepth, rDepth);
	        }
	    }
	    
	    int minHeight = Integer.MAX_VALUE;
	    private void minDepth(Node root, int depth) {
	        if(root == null){
	            return;
	        }
	        if(root.left == null && root.right == null){
	            minHeight = Math.min(depth, minHeight);
	        }
	        minDepth(root.left, depth+1);
	        minDepth(root.right, depth+1);        
	    }
	    
	    private int minDepth2(Node root){
	        if(root == null){
	            return 0;
	        }
	        
	        int leftHeight = minDepth2(root.left);
	        int rightHeight = minDepth2(root.right);
	        if(root.left == null){
	            return 1 + rightHeight;
	        } else if(root.right == null){
	            return 1 + leftHeight;
	        }
	        return 1 + Math.min(leftHeight, rightHeight);
	    }
	    
	    public int minimumWidthRecursion(Node node)
		{
			return minimumWidthRecursionUtl(node,1);
		}
		
		public int minimumWidthRecursionUtl(Node node, int level)
		{
			if(node == null || (node.left == null && node.right == null))
			{
				return level;
			}
			
			int leftLevel = minimumWidthRecursionUtl(node.left, level+1);
			int rightLevel = minimumWidthRecursionUtl(node.right, level+1);
			return Math.min(leftLevel, rightLevel);
		}
		
		public int minimumDepth(Node node)
		{
			Queue<Node> queue = new LinkedList<>();
			if(node == null)
			{
				return 0;
			}
			int minimumWidth = 0;
			queue.offer(node);
			while(!queue.isEmpty())
			{
				int size = queue.size();
				minimumWidth++;
				
				while(size!=0)
				{
					size--;
					Node localNode = queue.poll();
					if(localNode.left == null && localNode.right == null)
					{
						return minimumWidth;
					}
					if(localNode.left !=null)
					{
						queue.offer(localNode.left);
					}
					if(localNode.right !=null)
					{
						queue.offer(localNode.right);
					}
					
					
				}
			}
			return minimumWidth;
		}
		
	    /* Driver program to test above functions */
	    public static void main(String[] args) 
	    {
	    	BinaryTreeDepth tree = new BinaryTreeDepth();
	  
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	  
	        System.out.println("Height of tree is : " + 
	                                      tree.maxDepth(tree.root));
	        
	        System.out.println("Minimum Depth of tree is : " + 
                    tree.minDepth(tree.root));
	        
	        System.out.println("Minimum Depth of tree is : " + 
                    tree.minimumDepth(tree.root));
	        
	        System.out.println("Minimum Depth of tree is : " + 
                    tree.minimumWidthRecursion(tree.root));
	    }
}

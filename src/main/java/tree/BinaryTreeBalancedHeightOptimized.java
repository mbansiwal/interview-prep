package tree;

class Height
{
	int height = 0;
}

public class BinaryTreeBalancedHeightOptimized
{
    Node root;

    boolean isBalanced(Node root, Height height)
    {
    	/* If tree is empty then return true */
        if (root == null)
        {
            height.height = 0;
            return true;
        }
 
        /* Get heights of left and right sub trees */
        Height lheight = new Height(), rheight = new Height();
        boolean l = isBalanced(root.left, lheight);
        boolean r = isBalanced(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;
 
        /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height = Math.max(lh,rh) + 1;
 
        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
		if (Math.abs(lh - rh) > 1)
        {
        	return false;
        }
        /* If this node is balanced and left and right subtrees
           are balanced then return true */
        else 
        {
        	return l && r;
        }
    }
    
 
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
    	BinaryTreeBalancedHeightOptimized tree = new BinaryTreeBalancedHeightOptimized();
    	tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
   
		if (tree.isBalanced(tree.root, new Height()))
             System.out.println("Tree is balanced");
         else
             System.out.println("Tree is not balanced");
    }
}
package tree;

public class BinaryTreeBalancedHeight
{
    Node root;
 
    /* Given a binary tree. Print its nodes in level order
       using array for implementing queue */
    int size()
    {
        return height(root);
    }
 
    boolean isBalanced(Node root)
    {
    	if(root == null)
    	{
    		return true;
    	}
    	else if(Math.abs(height(root.left) - height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right))
    	{
    		return true;
    	}
    	return false;
    }
    
    /* computes number of nodes in tree */
    int height(Node node)
    {
        if (node == null)
        {
        	return 0;
        }
        else
        {
        	return 1 + Math.max(height(node.left), height(node.right));
        }
    }
 
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
    	BinaryTreeBalancedHeight tree = new BinaryTreeBalancedHeight();
         tree.root = new Node(1);
         tree.root.left = new Node(2);
         tree.root.right = new Node(3);
         tree.root.left.left = new Node(4);
         tree.root.left.right = new Node(5);
         tree.root.left.left.left = new Node(8);
   
         if(tree.isBalanced(tree.root))
             System.out.println("Tree is balanced");
         else
             System.out.println("Tree is not balanced");
    }
}
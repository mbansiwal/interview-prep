package tree;

public class BinaryTreeLeafNodes
{
    Node root;
 
    /* Given a binary tree. Print its nodes in level order
       using array for implementing queue */
    int leafNodes()
    {
        return leafNodes(root);
    }
 
    /* computes number of nodes in tree */
    int leafNodes(Node node)
    {
        if (node == null)
        {
        	return 0;
        }
        if(node.left == null && node.right==null)
        {
        	return 1;
        }
        else
        {
        	return(leafNodes(node.left) + leafNodes(node.right));
        }
    }
 
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
    	BinaryTreeLeafNodes tree = new BinaryTreeLeafNodes();
    	tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
          
        /* get leaf count of the abve tree */
        System.out.println("The leaf count of binary tree is : "
                             + tree.leafNodes());
    }
}
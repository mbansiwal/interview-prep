package tree;

//Java program to print left view of binary tree
/* Class to print the left view */
class BinaryTreeIdenticalTree
{
	Node root;
	static int maxLevel = 0;

	// recursive function to print left view
	boolean identicalTrees(Node root1, Node root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		else if(root1 !=null && root2 !=null)
		{ 
			return (root1.data == root2.data && identicalTrees(root1.left, root2.left) && 
					identicalTrees(root1.right, root2.right));
		}
		else
		{
			return false;
		}
	}

	/* testing for example nodes */
	public static void main(String args[])
	{
		BinaryTreeIdenticalTree tree1 = new BinaryTreeIdenticalTree();
		  
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
  
        BinaryTreeIdenticalTree tree2 = new BinaryTreeIdenticalTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
  
        
        if (tree1.identicalTrees(tree1.root, tree2.root))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
	}
}


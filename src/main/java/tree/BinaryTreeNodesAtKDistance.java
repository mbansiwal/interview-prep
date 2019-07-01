package tree;

//Java program to print left view of binary tree
/* Class to print the left view */
class BinaryTreeNodesAtKDistance
{
	Node root;
	
	void printDownNodesAtKDistance(Node node, int k)
	{
		if (node == null || k < 0)
		{
			return;
		}
		if (k == 0)
		{
			System.out.println("Down Node " + node.data);
			return;
		}
		printDownNodesAtKDistance(node.left, k - 1);
		printDownNodesAtKDistance(node.right, k - 1);
	}

	int findAllNodeAtKDistance(Node node, int key, int k)
	{
		if(node == null)
		{
			return -1;
		}
		
		if(node.data == key)
		{
			printDownNodesAtKDistance(node, k);
			return 0;
		}
		int dl = findAllNodeAtKDistance(node.left, key, k);
		
		if(dl!=-1)
		{
			if(dl+1 == k)
			{
				System.out.print(node.data+" ");
			}
			else
			{
				printDownNodesAtKDistance(node.right, k-dl-2);
			}
			return dl+1;
		}
		
		int dr = findAllNodeAtKDistance(node.right, key, k);
		
		if(dr != -1)
		{
			if(dr+1 == k)
			{
				System.out.print(node.data+" ");
			}
			else
			{
				printDownNodesAtKDistance(node.left, k-dr-2);
			}
			return dr + 1;
		}
		
		return -1;
	}
	
	/* testing for example nodes */
	public static void main(String args[])
	{
		/* creating a binary tree and entering the nodes */
		BinaryTreeNodesAtKDistance tree = new BinaryTreeNodesAtKDistance();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		tree.findAllNodeAtKDistance(tree.root, 8, 2);
		System.out.println();
		tree.findAllNodeAtKDistance(tree.root, 14, 3);
	}
}


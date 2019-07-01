package tree;

//Java program to print left view of binary tree
/* Class to print the left view */
class LeafNodesAtKDistance
{
	int MAX_VALUE = 100000;
	Node root;
	int minDistance = MAX_VALUE;
	int count = 0;
	
	int findLeafNodeDistance(Node node)
	{
		count++;
		// Base Case
		if (node==null) 
		{
			return MAX_VALUE;
		}
		
		if(node.left == null && node.right == null)
		{
			return 0;
		}
		// Recur for left and right subtrees
		return 1 + Math.min(findLeafNodeDistance(node.left), findLeafNodeDistance(node.right));
	}
	
	int findAllNodeAtKDistance(Node node, int key)
	{
		count++;
		if(node == null)
		{
			return -1;
		}
		
		if(node.data == key)
		{
			minDistance = findLeafNodeDistance(node);
			return 0;
		}
		int dl = findAllNodeAtKDistance(node.left, key);
		if(dl!=-1 && dl+2 < minDistance)
		{
			minDistance = Math.min(minDistance, dl + 2 + findLeafNodeDistance(node.right));
			return dl+1;
		}
		
		int dr = findAllNodeAtKDistance(node.right, key);
		if(dr != -1 && dr+2 < minDistance)
		{
			minDistance = Math.min(minDistance, dr + 2 + findLeafNodeDistance(node.left));
			return dr + 1;
		}
		return -1;
	}
	
	void findMinimumDistance(Node node, int key)
	{
		count = 0;
		minDistance = MAX_VALUE;
		
		findAllNodeAtKDistance(node, key);
	}
	
	/* testing for example nodes */
	public static void main(String args[])
	{
		/* creating a binary tree and entering the nodes */
		LeafNodesAtKDistance tree = new LeafNodesAtKDistance();
		tree.root = new Node('A');
        tree.root.left = new Node('B');
        tree.root.right = new Node('C');
        tree.root.right.left = new Node('E');
        tree.root.right.right = new Node('F');
        tree.root.right.left.left = new Node('G');
        tree.root.right.left.left.left = new Node('I');
        tree.root.right.left.left.right = new Node('J');
        tree.root.right.right.right = new Node('H');
        tree.root.right.right.right.left = new Node('K');

        tree.findMinimumDistance(tree.root, 'H');
        System.out.println(tree.count+" iterations for "+tree.minDistance);
		
		tree.findMinimumDistance(tree.root, 'C');
		System.out.println(tree.count+" iterations for "+tree.minDistance);
		
		tree.findMinimumDistance(tree.root, 'E');
		System.out.println(tree.count+" iterations for "+tree.minDistance);
		
		tree.findMinimumDistance(tree.root, 'B');
		System.out.println(tree.count+" iterations for "+tree.minDistance);
		
		tree.findMinimumDistance(tree.root, 'F');
		System.out.println(tree.count+" iterations for "+tree.minDistance);
	}
}


package tree;

public class ConstructBstFromPreOrder
{
	public static void main(String[] args)
	{
		ConstructBstFromPreOrder tree = new ConstructBstFromPreOrder();
		int pre[] = new int[]
		{
				10, 5, 1, 7, 40, 50
		};
		int size = pre.length;
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
	}

	private void printInorder(Node root)
	{
		if (root == null)
		{
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

	private Node constructTree(int[] pre, int size)
	{
		Index index = new Index();
		return constructTree(pre, index, size, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private Node constructTree(int[] pre, Index indexCounter, int size, int low, int high)
	{
		if (indexCounter.index >= size)
		{
			return null;
		}
		int key = pre[indexCounter.index];
		Node root = null;
		if (low < key && key < high)
		{
			root = new Node(key);
			indexCounter.index++;
			root.left = constructTree(pre, indexCounter, size, low, key);
			root.right = constructTree(pre, indexCounter, size, key, high);
		}

		return root;
	}

	class Index
	{

		int index = 0;
	}
}

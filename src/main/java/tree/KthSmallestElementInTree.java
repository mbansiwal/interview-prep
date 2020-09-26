package tree;

class Count
{
	int c = 0;
}

public class KthSmallestElementInTree
{
	Node root;

	public static void main(String[] args)
	{
		KthSmallestElementInTree tree = new KthSmallestElementInTree();

		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.kthSmallest(5);

		// for (int i = 1; i <= 7; i++)
		// {
		// tree.kthSmallest(i);
		// }
	}

	private void kthSmallest(int k)
	{
		Count count = new Count();
		kthSmallest(root, k, count);
	}

	private void kthSmallest(Node node, int k, Count count)
	{
		if (node == null || count.c > k)
		{
			return;
		}
		kthSmallest(node.left, k, count);
		count.c++;
		if (count.c == k)
		{
			System.out.println(node.data);
		}

		kthSmallest(node.right, k, count);
	}
	private void insert(int data)
	{
		if (root == null)
		{
			this.root = new Node(data);
		} else
		{
			insertRec(this.root, data);
		}

	}

	private Node insertRec(Node node, int data)
	{
		if (node == null)
		{
			return new Node(data);
		}

		if (node.data < data)
		{
			node.right = insertRec(node.right, data);
		} else if (node.data > data)
		{
			node.left = insertRec(node.left, data);
		}
		return node;
	}
}

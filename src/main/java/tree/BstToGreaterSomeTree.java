package tree;

class Sum
{
	int sum;
}
public class BstToGreaterSomeTree
{
	private Node root;


	public BstToGreaterSomeTree(int data)
	{
		this.root = new Node(data);
	}

	void transformTree(Node node)
	{
		transformTree(node, new Sum());
	}

	void transformTree(Node node, Sum sum)
	{
		if (node == null)
		{
			return;
		}
		transformTree(node.right, sum);
		int temp = node.data;
		node.data = sum.sum;
		sum.sum = sum.sum + temp;
		transformTree(node.left, sum);
	}

	void printInorder(Node node)
	{
		if (node == null)
		{
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + ",");
		printInorder(node.right);
	}
	public static void main(String[] args)
	{
		BstToGreaterSomeTree tree = new BstToGreaterSomeTree(11);
		tree.root.left = new Node(2);
		tree.root.right = new Node(29);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(40);
		tree.root.right.right.left = new Node(35);
		tree.printInorder(tree.root);
		System.out.println();
		tree.transformTree(tree.root);
		tree.printInorder(tree.root);
	}

}

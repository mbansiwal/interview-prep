package tree;

public class BinaryTreeAsNumber
{
	private Node root;


	public BinaryTreeAsNumber(int data)
	{
		this.root = new Node(data);
	}

	int transformTree2(Node node)
	{
		if (node == null)
		{
			return 0;
		}
		StringBuilder sb = new StringBuilder("");
		transformTree2(node.left, sb);

		sb.append(node.data);
		StringBuilder sbRight = new StringBuilder("");
		transformTree2(node.right, sbRight);
		return Integer.parseInt(sb.append(sbRight.reverse()).toString());
	}
	void transformTree2(Node node, StringBuilder sb)
	{
		if (node == null)
		{
			return;
		}
		transformTree2(node.right, sb);
		transformTree2(node.left, sb);
		sb.append(node.data);
	}


	public static void main(String[] args)
	{
		BinaryTreeAsNumber tree = new BinaryTreeAsNumber(4);
		tree.root.left = new Node(3);
		tree.root.left.right = new Node(2);
		tree.root.left.right.left = new Node(1);
		tree.root.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.left.right = new Node(7);
		tree.root.right.left.right.left = new Node(8);
		System.out.println(tree.transformTree2(tree.root));

		StringBuilder sb = new StringBuilder();

		System.out.println(sb.toString());
	}

}

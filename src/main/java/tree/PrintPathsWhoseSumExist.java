package tree;

public class PrintPathsWhoseSumExist
{
	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		PrintPathsWhoseSumExist i = new PrintPathsWhoseSumExist();
		i.hasPath(root, 10, "");
	}

	private void hasPath(Node node, int sum, String path)
	{
		if (node == null)
		{
			return;
		}

		if (node.data > sum)
		{
			return;
		}
		path = path + " " + node.data;
		sum = sum - node.data;
		if (sum == 0)
		{
			System.out.println(path);
		}
		hasPath(node.left, sum, path);
		hasPath(node.right, sum, path);
	}
}

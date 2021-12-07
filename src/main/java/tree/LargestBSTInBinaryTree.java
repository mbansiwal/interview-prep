package tree;

public class LargestBSTInBinaryTree 
{
	Node root;
	
	class Result
	{
		boolean isBst;
		int size;
		int largestTreeSize;
		int minNode;
		int maxNode;
		
		public Result(boolean isBst, int size, int answer, int minNode, int maxNode)
		{
			super();
			this.isBst = isBst;
			this.size = size;
			this.largestTreeSize = answer;
			this.maxNode = maxNode;
			this.minNode = minNode;
		}
		
		public Result()
		{
			super();
			this.isBst = false;
			this.size = 0;
			this.largestTreeSize = 0;
			this.maxNode = Integer.MAX_VALUE;
			this.minNode = Integer.MIN_VALUE;
		}

		public Result bst(boolean bst)
		{
			this.isBst = bst;
			return this;
		}

		public Result size(int size)
		{
			this.size = size;
			return this;
		}

		@Override
		public String toString() {
			return isBst+","+size+","+largestTreeSize+","+minNode+","+maxNode;
		}
	}
	
	public Result isBST(Node node)
	{
		if (node == null)
		{
			return new Result().bst(true);
		}
		if (node.left == null && node.right == null)
		{
			return new Result(true, 1, 1, node.data, node.data);
		}

		Result leftResult = isBST(node.left);
		Result rightResult = isBST(node.right);

		int size = leftResult.size + rightResult.size + 1;
		Result result = new Result().size(size);
		if (leftResult.isBst && rightResult.isBst && leftResult.maxNode < node.data && rightResult.minNode > node.data)
		{
			result.maxNode = rightResult.maxNode;
			result.minNode = leftResult.minNode;
			result.isBst = true;
			result.largestTreeSize = size;
		} else
		{
			result.largestTreeSize = Math.max(leftResult.size, rightResult.size);
		}

		return result;
	}
	
	public static void main(String[] args) 
	{
		LargestBSTInBinaryTree tree = new LargestBSTInBinaryTree();
		tree.root = new Node(50);
		tree.root.left = new Node(10);
		tree.root.right = new Node(60);
		
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(20);
		
		tree.root.right.left = new Node(55);
		tree.root.right.left.left = new Node(45);
		tree.root.right.right = new Node(70);
		tree.root.right.right.left = new Node(65);
		tree.root.right.right.right = new Node(80);
		
		System.out.println(tree.isBST(tree.root).largestTreeSize);
		
		tree.root = new Node(60);
		tree.root.left = new Node(65);
		tree.root.right = new Node(70);
		tree.root.left.left = new Node(50);
		System.out.println(tree.isBST(tree.root).largestTreeSize);
	}
}

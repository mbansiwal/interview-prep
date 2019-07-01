package tree;

public class ConvertToThreadedBinaryTree 
{
	Node root;
	
	public Node create(Node node)
	{
		if(node == null) return null;
		
		if(node.left == null && node.right == null)
		{
			return node;
		}
		
		if(node.left != null)
		{
			Node predecessor = create(node.left);
			predecessor.right = node;
			predecessor.isThreaded = true;
		}
		
		if(node.right == null)
		{
			return node;
		}
		
		return create(node.right);
	}
	
	public Node leftMost(Node node)
	{
		while(node!=null && node.left != null)
		{
			node = node.left;
		}
		return node;
	}
	
	public void inorder(Node node)
	{
		if(node == null) return;
		
		Node currentNode = leftMost(node);
		
		while(currentNode != null)
		{
			System.out.print(currentNode.data + " ");
			
			if(currentNode.isThreaded)
			{
				currentNode = currentNode.right;
			}
			else
			{
				currentNode = leftMost(currentNode.right);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		ConvertToThreadedBinaryTree tree = new ConvertToThreadedBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		tree.create(tree.root);
		tree.inorder(tree.root);
	}
}

package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeWidth 
{
	Node root;
	Queue<Node> queue = new LinkedList<>();
	
	public int maxWidth(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int maxWidth = 0;
		queue.offer(node);
		while(!queue.isEmpty())
		{
			int localWidth = queue.size();
			maxWidth = Math.max(maxWidth, localWidth);
			while(localWidth!=0)
			{
				localWidth--;
				Node localNode = queue.poll();
				
				if(localNode.left !=null)
				{
					queue.offer(localNode.left);
				}
				if(localNode.right !=null)
				{
					queue.offer(localNode.right);
				}
			}
		}
		return maxWidth;
	}
	
	public static void main(String[] args) {
		BinaryTreeWidth tree = new BinaryTreeWidth();
	     tree.root = new Node(1);
	     tree.root.left = new Node(2);
	     tree.root.right = new Node(3);
	     tree.root.left.left = new Node(4);
	     tree.root.left.right = new Node(5);
	     tree.root.right.right = new Node(8);
	     tree.root.right.right.left = new Node(6);
	     tree.root.right.right.right = new Node(7);
	     
	     System.out.println(tree.maxWidth(tree.root));
	     
	     tree.root = new Node(1);
	     tree.root.left = new Node(2);
	     tree.root.right = new Node(3);
	     tree.root.left.left = new Node(4);
	     tree.root.right.right = new Node(8);
	     tree.root.right.right.left = new Node(6);
	     tree.root.right.right.right = new Node(7);
	     System.out.println(tree.maxWidth(tree.root));

	}
}

package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePrintEdgesAnticlockwise 
{
	Node root;
	Queue<Node> queue = new LinkedList<>();
	Stack<Node> rightStack = new Stack<>();
	
	public void printEdges(Node node)
	{
		if(node == null)
		{
			return;
		}
		queue.offer(node);
		while(!queue.isEmpty())
		{
			int localWidth = queue.size();
			boolean first = true;
			while(localWidth!=0)
			{
				localWidth--;
				Node localNode = queue.poll();
				
				if(first)
				{
					System.out.print(localNode.data + ",");
					first = false;
				}
				else if(localWidth == 0)
				{
					rightStack.push(localNode);
				}
				
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
		
		while(!rightStack.isEmpty())
		{
			Node localNode = rightStack.pop();
			System.out.print(localNode.data + ",");
		}
	}
	
	public static void main(String[] args) {
		BinaryTreePrintEdgesAnticlockwise tree = new BinaryTreePrintEdgesAnticlockwise();
	     tree.root = new Node(15);
	     tree.root.left = new Node(10);
	     tree.root.right = new Node(20);
	     tree.root.left.left = new Node(8);
	     tree.root.left.right = new Node(12);
	     tree.root.right.left = new Node(16);
	     tree.root.right.right = new Node(25);
	     
	     tree.printEdges(tree.root);
	     System.out.println();
	     tree.root = new Node(1);
	     tree.root.right = new Node(2);
	     tree.root.right.right = new Node(3);
	     tree.printEdges(tree.root);
	    
	     System.out.println();
	     tree = new BinaryTreePrintEdgesAnticlockwise();
	    tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printEdges(tree.root);
	}
}

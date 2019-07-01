package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePrintEdges 
{
	Node root;
	Queue<Node> queue = new LinkedList<>();
	
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
				
				if(first || localWidth == 0)
				{
					System.out.print(localNode.data + ",");
					first = false;
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
	}
	
	public void printLeftBoundary(Node node)
	{
		if(node != null)
		{
			if(node.left != null)
			{
				print(node);
				printLeftBoundary(node.left);
			}
			else if(node.right != null)
			{
				print(node);
				printLeftBoundary(node.right);
			}
		}
	}
	
	public void printRightBoundary(Node node)
	{
		if(node != null)
		{
			if(node.right != null)
			{
				printRightBoundary(node.right);
				print(node);
			}
			else if(node.left != null)
			{
				printRightBoundary(node.left);
				print(node);
			}
		}
	}
	
	public void printLeaves(Node node)
	{
		if(node != null)
		{
			printLeaves(node.left);
			if(node.left == null && node.right == null)
			{
				print(node);
			}
			printLeaves(node.right);
		}
	}
	
	public void printBoundaries(Node node)
	{
		if(node != null)
		{
			print(node);
			printLeftBoundary(node.left);
			printLeaves(node.left);
			printLeaves(node.right);
			printRightBoundary(node.right);
		}
		
	}
	
	private void print(Node node)
	{
		System.out.print(node.data + " ");
	}
	
	public static void main(String[] args) {
		BinaryTreePrintEdges tree = new BinaryTreePrintEdges();
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
	     tree = new BinaryTreePrintEdges();
	    tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.root.right.right.left = new Node(26);
        tree.root.right.right.right = new Node(27);
        tree.printBoundaries(tree.root);
	}
}

package tree;

import java.util.Stack;

//Java program for different tree traversals

class BinaryTreeInorderTraversalWithoutRecursion
{
 // Root of Binary Tree
 Node root;

 BinaryTreeInorderTraversalWithoutRecursion()
 {
     root = null;
 }


	void printInorder2(Node node)
	{
		Stack<Node> stack = new Stack<>();
		while (node != null || !stack.isEmpty())
		{
			while (node != null)
			{
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();
			System.out.print(node.data + " ");

			node = node.right;
		}
	}

 // Wrappers over above recursive functions
 void printInorder()    {     printInorder2(root);   }

 // Driver method
 public static void main(String[] args)
 {
     BinaryTreeInorderTraversalWithoutRecursion tree = new BinaryTreeInorderTraversalWithoutRecursion();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);

     System.out.println("\nInorder traversal of binary tree is ");
     tree.printInorder();
 }
}
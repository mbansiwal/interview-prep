package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

//Java program for different tree traversals

class BinaryTreeTraversal
{
	// Root of Binary Tree
	Node root;

	BinaryTreeTraversal()
	{
		root = null;
	}

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up"
	 * postorder traversal.
	 */
	void printPostorder(Node node)
	{
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.data + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	void printInorder(Node node)
	{
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	void printPreorder(Node node)
	{
		if (node == null)
		{
			return;
		}

		/* first print data of node */
		System.out.print(node.data + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	void printReverseLevelOrderTravesal()
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		Stack<Node> stack = new Stack<>();
		while (!queue.isEmpty())
		{
			Node node = queue.poll();
			stack.push(node);
			if (node.right != null)
			{
				queue.add(node.right);
			}
			if (node.left != null)
			{
				queue.add(node.left);
			}
		}

		while (!stack.isEmpty())
		{
			System.out.print(stack.pop().data + " ");
		}
	}

	/* Given a binary tree, print its nodes in preorder */
	void printLevelOrderOrBFS(Node node)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty())
		{
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			if (tempNode.left != null)
			{
				queue.add(tempNode.left);
			}

			if (tempNode.right != null)
			{
				queue.add(tempNode.right);
			}
		}
	}

	void printSpiral(Node node)
	{
		if (node == null)
			return; // NULL check

		// Create two stacks to store alternate levels
		Stack<Node> s1 = new Stack<Node>();// For levels to be printed from
											// right to left
		Stack<Node> s2 = new Stack<Node>();// For levels to be printed from left
											// to right

		// Push first level to first stack 's1'
		s1.push(node);

		// Keep ptinting while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty())
		{
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty())
			{
				Node temp = s1.peek();
				s1.pop();
				System.out.print(temp.data + " ");

				// Note that is right is pushed before left
				if (temp.right != null)
					s2.push(temp.right);

				if (temp.left != null)
					s2.push(temp.left);

			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty())
			{
				Node temp = s2.peek();
				s2.pop();
				System.out.print(temp.data + " ");

				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

	void printSpiralWithOneQueue(Node node)
	{
		if (node == null)
		{
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		boolean toggle = false;
		while (!queue.isEmpty())
		{
			int count = queue.size();
			toggle = !toggle;
			while (count != 0)
			{
				--count;
				Node temp = queue.poll();
				System.out.print(temp.data + ",");
				if (toggle)
				{
					if (temp.left != null)
					{
						queue.offer(temp.left);
					}

					if (temp.right != null)
					{
						queue.offer(temp.right);
					}
				} else
				{
					if (temp.right != null)
					{
						queue.offer(temp.right);
					}
					if (temp.left != null)
					{
						queue.offer(temp.left);
					}
				}
			}
		}
	}

	void printBoundaryTraversal(Node node)
	{
		if (node == null)
		{
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);

		List<Integer> rightNodes = new ArrayList<>();
		while (!queue.isEmpty())
		{
			int count = queue.size();
			boolean first = true;
			while (count != 0)
			{
				--count;
				Node temp = queue.poll();

				if (first)
				{
					System.out.print(temp.data + " ");
					first = false;
				} else if (count == 0)
				{
					rightNodes.add(temp.data);
				}
				if (temp.left != null)
				{
					queue.offer(temp.left);
				}

				if (temp.right != null)
				{
					queue.offer(temp.right);
				}
			}
		}

		for (int i = rightNodes.size() - 1; i >= 0; i--)
		{
			System.out.print(rightNodes.get(i) + " ");
		}
	}

	void printBottomView(Node node)
	{
		if (node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		int hd = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		while (!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			hd = currentNode.level;
			map.put(hd, currentNode.data);
			if (currentNode.left != null)
			{
				currentNode.left.level = hd - 1;
				queue.add(currentNode.left);
			}
			if (currentNode.right != null)
			{
				currentNode.right.level = hd + 1;
				queue.add(currentNode.right);
			}
		}

		for (Integer key : map.keySet())
		{
			System.out.print(map.get(key) + ",");
		}
	}

	void printBottomViewRecur(Node node)
	{
		Map<Integer, Integer> map = new TreeMap<>();
		printBottomViewRecur(node, 0, map);
		for (Integer key : map.keySet())
		{
			System.out.print(map.get(key) + ",");
		}
	}

	void printBottomViewRecur(Node node, int hd, Map<Integer, Integer> map)
	{
		if (node == null)
			return;
		map.put(hd, node.data);
		printBottomViewRecur(node.left, hd - 1, map);
		printBottomViewRecur(node.right, hd + 1, map);
	}

	// Wrappers over above recursive functions
	void printPostorder()
	{
		printPostorder(root);
	}

	void printInorder()
	{
		printInorder(root);
	}

	void printPreorder()
	{
		printPreorder(root);
	}

	void printSpiral()
	{
		printSpiral(root);
	}

	// Driver method
	public static void main(String[] args)
	{
		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();

		System.out.println("\nLevel Order or BFS traversal of binary tree is ");
		tree.printLevelOrderOrBFS(tree.root);

		System.out.println("\nReverse Level Order or BFS traversal of binary tree is ");
		tree.printReverseLevelOrderTravesal();

		System.out.println("\nSpiral Order traversal of binary tree is ");
		tree.printSpiral();

		System.out.println("\nSpiral Order traversal of binary tree With One Queue ");
		tree.printSpiralWithOneQueue(tree.root);

		System.out.println("\nBoundary traversal of binary tree With One Queue ");
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(3);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(25);
		tree.printBoundaryTraversal(tree.root);
		System.out.println("\nBottom view of binary tree With One Queue ");
		tree.printBottomView(tree.root);

		System.out.println("\nBottom view of binary tree With Recursion ");
		tree.printBottomView(tree.root);
	}
}
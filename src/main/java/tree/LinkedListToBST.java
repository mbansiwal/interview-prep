package tree;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListToBST
{
	static LinkedList<Integer> llist = new LinkedList();
	static ListIterator<Integer> listItr = null;

	public static void main(String[] args)
	{
        llist.push(7); 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
		listItr = llist.listIterator();
        System.out.println("Given Linked List "); 
  
        /* Convert List to BST */
		Node root = sortedListToBST();
        System.out.println(""); 
        System.out.println("Pre-Order Traversal of constructed BST "); 
		preOrder(root);
	}

	private static Node sortedListToBST()
	{
		int count = llist.size();
		return sortedListToBST(count);
	}

	private static Node sortedListToBST(int n)
	{
		if (n <= 0)
		{
			return null;
		}

		Node left = sortedListToBST(n / 2);
		Node root = new Node(listItr.next());
		root.left = left;
		Node right = sortedListToBST(n - n / 2 - 1);
		root.right = right;
		return root;
	}

	public Node LLToBST(int start, int end)
	{
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node leftChild = LLToBST(start, mid - 1);
		Node root = new Node(listItr.next());
		root.left = leftChild;
		root.right = LLToBST(mid + 1, end);
		return root;
	}

	private static void preOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
}

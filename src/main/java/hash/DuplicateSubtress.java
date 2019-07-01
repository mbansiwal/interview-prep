package hash;

import java.util.HashMap;

/**
 * Given a binary tree, find all duplicate subtrees. For each duplicate
 * subtrees, we only need to return the root node of any one of them. Two trees
 * are duplicate if they have the same structure with same node values.
 * 
 * Examples:
 * 
 * Input : Output : and Explanation: Above Trees are two duplicate subtrees.
 * Therefore, you need to return above trees root in the form of a list.
 * 
 * 
 * @author mbansiwal
 *
 */
public class DuplicateSubtress
{
	/*
	 * A binary tree node has data, pointer to left child and a pointer to right
	 * child
	 */
	static HashMap<String, Integer> inorderRecordMap = new HashMap<>();

	static class Node
	{
		int data;
		Node left;
		Node right;

		Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}

	static String findDuplicate(Node tree){
		if(tree == null){
			return "";
		}

		String str = "{";
		str += findDuplicate(tree.left);
		str += Integer.toString(tree.data);
		str += findDuplicate(tree.right);
		str += "}";

		//print duplicate tree once
		if (inorderRecordMap.getOrDefault(str, 0) == 1)
		{
			System.out.print(tree.data + " ");
		}

		inorderRecordMap.put(str, inorderRecordMap.getOrDefault(str, 0)+1);

		return str;
	}






	static String inorder(Node node)
	{
		if (node == null)
			return "";

		String str = "(";
		str += inorder(node.left);
		str += Integer.toString(node.data);
		str += inorder(node.right);
		str += ")";

		// Subtree already present (Note that we use
		// HashMap instead of HashSet
		// because we want to print multiple duplicates
		// only once, consider example of 4 in above
		// subtree, it should be printed only once.
		if (inorderRecordMap.containsKey(str) && inorderRecordMap.get(str) == 1)
		{
			System.out.println(node.data + " ");
		}


		inorderRecordMap.put(str, inorderRecordMap.getOrDefault(str,0) + 1);

		return str;
	}

	// Wrapper over inorder()
	static void printAllDups(Node root)
	{
		inorderRecordMap = new HashMap<>();
		inorder(root);
	}

	// Driver code
	public static void main(String args[])
	{
		Node root = null;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(2);
		root.right.left.left = new Node(4);
		root.right.right = new Node(4);
		findDuplicate(root);
	}
}

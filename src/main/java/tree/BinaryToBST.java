package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryToBST
{
	private Node root;

	class Index
	{
		int index;
	}
	private void toInOrder(Node root, List<Integer> dataArr)
	{
		if (root == null)
		{
			return;
		}
		toInOrder(root.left, dataArr);
		dataArr.add(root.data);
		toInOrder(root.right, dataArr);
	}

	private void binaryTreeToBST(Node node)
	{
		List<Integer> dataArr = new ArrayList<>();
		toInOrder(node, dataArr);
		Integer[] inOrderArr = dataArr.toArray(new Integer[0]);
		Arrays.sort(inOrderArr);
		Index index = new Index();
		createBST(root, inOrderArr, index);
	}

	private void createBST(Node node, Integer[] inOrderArr, Index index)
	{
		if (node == null)
		{
			return;
		}
		createBST(node.left, inOrderArr, index);
		node.data = inOrderArr[index.index];
		index.index++;
		createBST(node.right, inOrderArr, index);
	}

	private void printInorder(Node node)
	{
		if (node == null)
		{
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + ",");
		printInorder(node.right);
	}
	
	public static void main(String args[])
	{
		BinaryToBST tree1 = new BinaryToBST();

		tree1.root = new Node(10);
		tree1.root.left = new Node(30);
		tree1.root.right = new Node(15);
		tree1.root.left.left = new Node(20);
		tree1.root.right.right = new Node(5);
		tree1.printInorder(tree1.root);
		System.out.println();
		tree1.binaryTreeToBST(tree1.root);
		tree1.printInorder(tree1.root);
	}
}

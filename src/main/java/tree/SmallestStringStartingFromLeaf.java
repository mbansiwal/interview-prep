package tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)
	{
		val = x;
	}
}


public class SmallestStringStartingFromLeaf
{
	int minLength = Integer.MAX_VALUE;
	String str = "";
	String ans = "~";

	public String smallestFromLeaf(TreeNode root)
	{
		findPath(root, 0, new ArrayList<>());
		return str;
	}

	public void findPath(TreeNode root, int length, List<Integer> paths)
	{
		if (root == null)
		{
			return;
		}

		paths.add(length, root.val);
		length++;
		if (root.left == null && root.right == null)
		{
			if (length == minLength)
			{
				String str1 = getString(paths, length);
				if (str1.compareTo(str) < 0)
				{
					str = str1;
				}
			} else if (length < minLength)
			{
				minLength = length;
				str = getString(paths, length);
			}
			return;
		}
		else
		{
			findPath(root.left, length, paths);
			findPath(root.right, length, paths);
		}
	}

	private String getString(List<Integer> paths, int length)
	{
		String str = "";
		for (int i = length - 1; i >= 0; i--)
		{
			char a = (char) ('a' + paths.get(i));
			str = str + a;
		}
		return str;
	}

	

	public String smallestFromLeaf2(TreeNode root)
	{
		dfs(root, new StringBuilder());
		return ans;
	}

	public void dfs(TreeNode node, StringBuilder sb)
	{
		if (node == null)
			return;
		sb.append((char) ('a' + node.val));

		if (node.left == null && node.right == null)
		{
			sb.reverse();
			String s = sb.toString();
			sb.reverse();

			if (s.compareTo(ans) < 0)
				ans = s;
		}

		dfs(node.left, sb);
		dfs(node.right, sb);
		sb.deleteCharAt(sb.length() - 1);
	}

	public static void main(String[] args)
	{
		TreeNode node = new TreeNode(25);
		node.left = new TreeNode(1);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		node.right = new TreeNode(3);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(2);
		System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(node));
		System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf2(node));
	}
}

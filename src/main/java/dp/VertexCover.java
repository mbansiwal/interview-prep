package dp;

/**
 * http://www.geeksforgeeks.org/vertex-cover-problem-set-2-dynamic-programming-solution-tree/
 * 
 * A vertex cover of an undirected graph is a subset of its vertices such that
 * for every edge (u, v) of the graph, either ‘u’ or ‘v’ is in vertex cover.
 * Although the name is Vertex Cover, the set covers all edges of the given
 * graph. The problem to find minimum size vertex cover of a graph is NP
 * complete. But it can be solved in polynomial time for trees. In this post a
 * solution for Binary Tree is discussed. The same solution can be extended for
 * n-ary trees.
 * 
 * For example, consider the following binary tree. The smallest vertex cover is
 * {20, 50, 30} and size of the vertex cover is 3. LargestIndependentSet1
 * 
 * The idea is to consider following two possibilities for root and recursively
 * for all nodes down the root. 1) Root is part of vertex cover: In this case
 * root covers all children edges. We recursively calculate size of vertex
 * covers for left and right subtrees and add 1 to the result (for root).
 * 
 * 2) Root is not part of vertex cover: In this case, both children of root must
 * be included in vertex cover to cover all root to children edges. We
 * recursively calculate size of vertex covers of all grandchildren and number
 * of children to the result (for two children of root).
 * 
 * @author mbansiwal
 *
 */
class Node
{
	int data;
	int vc;
	Node left;

	public Node(int data)
	{
		super();
		this.data = data;
	}

	Node right;
}

public class VertexCover
{
	public static int cover(Node node)
	{
		if (node == null || node.left == null || node.right == null)
		{
			return 0;
		}

		if (node.vc != 0)
		{
			return node.vc;
		}

		int inc = 1 + cover(node.left) + cover(node.right);
		int exc = 0;

		if (node.left != null)
		{
			exc += 1 + cover(node.left.left) + cover(node.left.right);
		}
		if (node.right != null)
		{
			exc += 1 + cover(node.right.left) + cover(node.right.right);
		}
		node.vc = Math.min(inc, exc);
		return node.vc;
	}

	public static int cover2(Node node)
	{
		if (node == null || node.left == null || node.right == null)
		{
			return 0;
		}
		if (node.vc != 0)
		{
			return node.vc;
		}

		int inc = 1 + cover(node.left) + cover(node.right);
		int exc = 0;
		if (node.left != null)
		{
			exc += 1 + cover(node.left.left) + cover(node.left.right);
		}
		if (node.right != null)
		{
			exc += 1 + cover(node.right.left) + cover(node.right.right);
		}
		node.vc = Math.min(inc, exc);
		return node.vc;
	}

	public static void main(String[] args)
	{
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);

		System.out.println(cover(root));
		System.out.println(cover2(root));
	}
}

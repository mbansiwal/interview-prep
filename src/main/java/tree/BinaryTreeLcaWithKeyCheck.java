package tree;

//Java program for different tree traversals

class BinaryTreeLcaWithKeyCheck {
	// Root of Binary Tree
	Node root;
	boolean n1Present;
	boolean n2Present;

	BinaryTreeLcaWithKeyCheck() {
		root = null;
	}

	public void lca(int n1, int n2) {
		n1Present = false;
		n2Present = false;
		Node lca = lca(root, n1, n2);

		if (n1Present && n2Present) {
			System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.data);
		} else {
			System.out.println("Keys are not present");
		}
	}
	public Node lca(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		Node temp = null;
		if (node.data == n1) {
			temp = node;
			n1Present = true;
		}
		if (node.data == n2) {
			temp = node;
			n2Present = true;
		}

		Node left = lca(node.left, n1, n2);
		Node right = lca(node.right, n1, n2);
		if (temp != null) {
			return temp;
		}

		if (left != null && right != null) {
			return node;
		}
		return left != null ? left : right;
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTreeLcaWithKeyCheck tree = new BinaryTreeLcaWithKeyCheck();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		int n1 = 4, n2 = 5;
		tree.lca(n1, n2);

		n1 = 4;
		n2 = 6;
		tree.lca(n1, n2);

		n1 = 3;
		n2 = 4;
		tree.lca(n1, n2);

		n1 = 2;
		n2 = 4;
		tree.lca(n1, n2);

		n1 = 2;
		n2 = 8;
		tree.lca(n1, n2);
	}
}
package tree;

public class ReverseAlternateLevelsOfAPerfectBinaryTree {
	Node root;
	
	private void swap(Node root1, Node root2)
	{
		int temp = root1.data;
		root1.data = root2.data;
		root2.data = temp;
	}
	
	private void reverse(Node root1, Node root2, int level)
	{
		if(root1 == null || root2 == null)
		{
			return;
		}
		if(level%2 == 0)
		{
			swap(root1, root2);
		}
		
		reverse(root1.left, root2.right, level+1);
		reverse(root1.right, root2.left, level+1);
	}
	
	public void reverseAlternate(Node root)
	{
		reverse(root.left, root.right, 0);
	}
	
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
	 
	public static void main(String[] args) 
	{
		ReverseAlternateLevelsOfAPerfectBinaryTree tree = new ReverseAlternateLevelsOfAPerfectBinaryTree();
		tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(9);
        tree.root.right.right = new Node(8);
        tree.printInorder(tree.root);
        
        tree.reverseAlternate(tree.root);
        System.out.println();
        tree.printInorder(tree.root);
	}

}

package tree;

public class BSTIsBST {
	Node root;
	
	boolean isBST()
	{
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	boolean isBST(Node node, int min, int max)
	{
		if(node == null)
		{
			return true;
		}
		if(node.data > max || node.data < min)
		{
			return false;
		}
		
		return isBST(node.left,min, node.data-1) && isBST(node.right, node.data+1, max);
	}
	
	public static void main(String[] args) 
	{
		BSTIsBST tree = new BSTIsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
	}
}

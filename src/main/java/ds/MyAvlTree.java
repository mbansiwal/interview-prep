package ds;

class AvlTreeNode
{
	int data;
	int height;
	AvlTreeNode left;
	AvlTreeNode right;
	public AvlTreeNode(int data) {
		super();
		this.data = data;
	}
}

public class MyAvlTree 
{
	AvlTreeNode root;
	public int height(AvlTreeNode node)
	{
		return node == null?0:node.height;
	}
	
	public int getBalance(AvlTreeNode node)
	{
		return node==null?0:(height(node.left)-height(node.right));
	}
	
	public AvlTreeNode rightRotate(AvlTreeNode z)
	{
		AvlTreeNode y = z.left;
		AvlTreeNode T3 = y.left;
		
		y.right = z;
		z.left=T3;
		z.height = Math.max(height(z.left), height(z.right))+1;
		y.height = Math.max(height(y.left), height(y.right))+1;
		return y;
	}
	
	public AvlTreeNode leftRotate(AvlTreeNode z)
	{
		AvlTreeNode y = z.right;
		AvlTreeNode T2 = y.left;
		
		y.left = z;
		z.right = T2;
		
		z.height = Math.max(height(z.left), height(z.right))+1;
		y.height = Math.max(height(y.left), height(y.right))+1;
		return y;
	}
	
	void inOrder(AvlTreeNode node) {
	     if (node != null) {
	    	 inOrder(node.left);
	         System.out.print(node.data + " ");
	         inOrder(node.right);
	     }
	 }
	
	public AvlTreeNode insert(AvlTreeNode node, int data)
	{
		if(node == null)
		{
			return new AvlTreeNode(data);
		}
		
		if(data < node.data)
		{
			node.left = insert(node.left, data);
		}
		else if(data > node.data)
		{
			node.right = insert(node.right, data);			
		}
		else
		{
			return node;
		}
		
		node.height = 1 + Math.max(height(node.left), height(node.right));
		int balance = getBalance(node);
		
		if(balance > 1 && data<node.left.data)
		{
			return rightRotate(node);
		}
		if(balance < -1 && data>node.right.data)
		{
			return leftRotate(node);
		}
		if(balance > 1 && data>node.left.data)
		{
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance < -1 && data < node.right.data)
		{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	
	public static void main(String[] args) {
		MyAvlTree tree = new MyAvlTree();

	    /* Constructing tree given in the above figure */
	    tree.root = tree.insert(tree.root, 10);
	    tree.root = tree.insert(tree.root, 20);
	    tree.root = tree.insert(tree.root, 30);
	    tree.root = tree.insert(tree.root, 40);
	    tree.root = tree.insert(tree.root, 50);
	    tree.root = tree.insert(tree.root, 25);

	    /* The constructed AVL Tree would be
	         30
	        /  \
	      20   40
	     /  \     \
	    10  25    50
	    */
	    System.out.println("Inorder traversal" +
	            " of constructed tree is : ");
	    tree.inOrder(tree.root);
	}
}

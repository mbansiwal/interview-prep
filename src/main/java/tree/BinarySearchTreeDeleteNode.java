package tree;

public class BinarySearchTreeDeleteNode 
{
	Node root;
	
	void deleteKey(int key)
	{
		this.root = deleteNode(root, key);
	}
	Node deleteNode(Node root,int key)
	{
		if(root == null)
		{
			return null;
		}
		else if(key < root.data)
		{
			root.left = deleteNode(root.left, key);
		}
		else if(key > root.data)
		{
			root.right = deleteNode(root.right, key);
		}
		else
		{
			if(root.left == null)
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.left;
			}
			else
			{
				int minRightNode = min(root.right);
				root.data = minRightNode;
				root.right = deleteNode(root.right, minRightNode);
			}
		}
		return root;
	}
	
	void printInorder(Node root)
	{
		if(root == null)
		{
			return;
		}
		printInorder(root.left);
		System.out.print(root.data+",");
		printInorder(root.right);
	}
	
	int min(Node root)
	{
		int minimum = root.data;
		while (root.left != null)
		{
			minimum = root.left.data;
			root = root.left;
		}
		return minimum;
	}
	
	void inorder()
    {
        printInorder(root);
    }
	
	void insert(int key)
	{
		this.root = insert(root,key);  
	}
	Node insert(Node root,int key)
	{
		if(root == null)
		{
			return new Node(key);
		}
		else if(key<root.data)
		{
			root.left=insert(root.left,key);
		}
		else if(key>root.data)
		{
			root.right=insert(root.right,key);
		}
		return root;
	}
	
	public static void main(String[] args) 
	{
		BinarySearchTreeDeleteNode tree = new BinarySearchTreeDeleteNode();
		 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();
 
        System.out.println("\nDelete 40");
        tree.deleteKey(40);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        
        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
	}

}

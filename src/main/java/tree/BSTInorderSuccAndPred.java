package tree;

public class BSTInorderSuccAndPred 
{
	Node root;
	Node pre;
	Node succ;
	
	void inOrder(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	Node max(Node node)
	{
		while(node.right != null)
		{
			node = node.right;
		}
		return node;
	}
	
	Node min(Node node)
	{
		while(node.left != null)
		{
			node = node.left;
		}
		return node;
	}
	
	void find2(Node node, int key)
	{
		if (node == null)
		{
			return;
		}

		if (node.data > key)
		{
			succ = node;
			find2(node.left, key);
		}
		if (node.data < key)
		{
			pre = node;
			find2(node.right, key);
		}
		if (node.data == key)
		{
			if (node.left != null)
			{
				pre = max(node.left);
			}
			if (node.right != null)
			{
				succ = min(node.right);
			}
		}
	}

	Node find(Node root,int key)
	{
		if(root == null)
		{
			return null;
		}
		else if(key < root.data)
		{
			succ = root;
			root.left = find(root.left, key);
		}
		else if(key > root.data)
		{
			pre = root;
			root.right = find(root.right, key);
		}
		else if(key == root.data)
		{
			if(root.left != null)
			{
				pre = max(root.left);
			}
			 if(root.right != null)
			{
				succ = min(root.right);
			}
		}
		return root;
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
		BSTInorderSuccAndPred tree = new BSTInorderSuccAndPred();
		 
        /* Let us create following BST
              50
           /     	\
          30      		70
         /  \    		/  \
        20   	40  	60   80 
	   /  \    /  \
      10  25   35  45    
        */
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);
        tree.insert(25);
        tree.insert(40);
        tree.insert(35);
        tree.insert(45);
        tree.insert(50);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inOrder(tree.root);
		tree.find2(tree.root, 30);
        System.out.println();
        System.out.println(tree.pre.data);
        System.out.println(tree.succ.data);
	}

}

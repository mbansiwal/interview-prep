package tree;

public class BinaryTreeIsSubtree {
	private void inOrderTraversal(Node node, StringBuilder sb) {
		if(node == null) {
			return;
		}
		inOrderTraversal(node.left, sb);
		sb.append(","+node.data);
		inOrderTraversal(node.right, sb);
	}
	
	private void preOrderTraversal(Node node, StringBuilder sb) {
		if(node == null) {
			return;
		}
		sb.append(","+(char)node.data);
		preOrderTraversal(node.left, sb);
		preOrderTraversal(node.right, sb);
	}
	
	public boolean isSubtree(Node root, Node subtree) {
		StringBuilder mainInorder = new StringBuilder();
		inOrderTraversal(root, mainInorder);
		
		StringBuilder mainPreorder = new StringBuilder();
		preOrderTraversal(root, mainPreorder);

		StringBuilder subtreeInorder = new StringBuilder();
		inOrderTraversal(subtree, subtreeInorder);
		
		StringBuilder subtreePreorder = new StringBuilder();
		preOrderTraversal(subtree, subtreePreorder);
		
		System.out.println("Main Inorder::"+mainInorder.toString());
		System.out.println("Main Preorder::"+mainPreorder.toString());
		System.out.println("Subtree Inorder::"+subtreeInorder.toString());
		System.out.println("Subtree Preorder::"+subtreePreorder.toString());
		return mainInorder.toString().contains(subtreeInorder.toString()) &&
		mainPreorder.toString().contains(subtreePreorder.toString());
	}
	
	public static void main(String[] args) {
		BinaryTreeIsSubtree tree = new BinaryTreeIsSubtree(); 
        Node T = new Node('a'); 
        T.left = new Node('b'); 
        T.right = new Node('d'); 
        T.left.left = new Node('c'); 
        T.right.right = new Node('e'); 
  
        Node S = new Node('a'); 
        S.left = new Node('b'); 
        S.right = new Node('d'); 
        S.left.left = new Node('c'); 
        
        if (tree.isSubtree(T, S)) { 
            System.out.println("Yes, S is a subtree of T"); 
        } 
        else { 
            System.out.println("No, S is not a subtree of T"); 
        }
        
        Node T2 = new Node('a'); 
        T2.left = new Node('b'); 
        T2.right = new Node('d'); 
        T2.left.left = new Node('c'); 
        T2.right.right = new Node('e'); 
  
        Node S2 = new Node('a'); 
        S2.left = new Node('e'); 
        S2.right = new Node('d'); 
        S2.left.left = new Node('c'); 
        
        if (tree.isSubtree(T2, S2)) { 
            System.out.println("Yes, S2 is a subtree of T2"); 
        } 
        else { 
            System.out.println("No, S2 is not a subtree of T2"); 
        }
        
        Node root1 = new Node(26); 
        root1.right = new Node(3); 
        root1.right.right = new Node(3); 
        root1.left = new Node(10); 
        root1.left.left = new Node(4); 
        root1.left.left.right = new Node(30); 
        root1.left.right = new Node(6); 
   
        // TREE 2 
        /* Construct the following tree 
           10 
         /    \ 
         4      6 
          \ 
          30  */
            
        Node root2 = new Node(10);
        root2.right = new Node(6); 
        root2.left = new Node(4); 
        root2.left.right = new Node(30); 
   
        if (tree.isSubtree(root1, root2)) 
            System.out.println("Tree 2 is subtree of Tree 1 "); 
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
	}
}

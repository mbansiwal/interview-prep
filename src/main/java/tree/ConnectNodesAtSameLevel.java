package tree;

/**
 * https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 *
 * Input Tree
 *        A
 *       / \
 *      B   C
 *     / \   \
 *    D   E   F
 *
 * Output Tree
 *        A--->NULL
 *       / \
 *      B-->C-->NULL
 *     / \   \
 *    D-->E-->F-->NULL
 */

public class ConnectNodesAtSameLevel {
    static class Node
    {
        int data;
        ConnectNodesAtSameLevel.Node left, right, nextRight;

        Node(int item)
        {
            data = item;
            left = right = nextRight = null;
        }
    }

    Node root; 
    
    /* Set next right of all descendents of p. This function makes sure that 
       nextRight of nodes ar level i is set before level i+1 nodes. */
    void connectRecur(Node p)  
    { 
        // Base case 
        if (p == null) 
        {
        	return; 
        }
   
        /* Before setting nextRight of left and right children, set nextRight 
           of children of other nodes at same level (because we can access  
           children of other nodes using p's nextRight only) */
        if (p.nextRight != null) 
        {
        	connectRecur(p.nextRight); 
        }
   
        /* Set the nextRight pointer for p's left child */
        if (p.left != null) 
        { 
            if (p.right != null)  
            { 
                p.left.nextRight = p.right; 
                p.right.nextRight = getNextRight(p); 
            }  
            else
            {
            	p.left.nextRight = getNextRight(p); 
            }
   
            /* Recursively call for next level nodes.  Note that we call only 
             for left child. The call for left child will call for right child */
            connectRecur(p.left); 
        } 
           
        /* If left child is NULL then first node of next level will either be 
         p->right or getNextRight(p) */
        else if (p.right != null)  
        { 
            p.right.nextRight = getNextRight(p); 
            connectRecur(p.right); 
        }  
        else
        {
        	connectRecur(getNextRight(p)); 
        }
    } 
   
    /* This function returns the leftmost child of nodes at the same 
       level as p. This function is used to getNExt right of p's right child 
       If right child of p is NULL then this can also be used for  
       the left child */
    Node getNextRight(Node p)  
    { 
        Node temp = p.nextRight; 
   
        /* Traverse nodes at p's level and find and return 
         the first node's first child */
        while (temp != null)  
        { 
            if (temp.left != null) 
            {
            	return temp.left; 
            }
            if (temp.right != null) 
            {
            	return temp.right; 
            }
            temp = temp.nextRight; 
        } 
   
        // If all the nodes at p's level are leaf nodes then return NULL 
        return null; 
    } 

        // Driver program to test above functions
        public static void main(String args[])
        {
            ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();

        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
            tree.root = new Node(10);
            tree.root.left = new Node(8);
            tree.root.right = new Node(2);
            tree.root.left.left = new Node(3);

            // Populates nextRight pointer in all nodes
            tree.connectRecur(tree.root);

            // Let us check the values of nextRight pointers
            System.out.println("Following are populated nextRight pointers in "
                    + "the tree" + "(-1 is printed if there is no nextRight)");
            int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
            System.out.println("nextRight of " + tree.root.data + " is "
                    + a);
            int b = tree.root.left.nextRight != null ?
                    tree.root.left.nextRight.data : -1;
            System.out.println("nextRight of " + tree.root.left.data + " is "
                    + b);
            int c = tree.root.right.nextRight != null ?
                    tree.root.right.nextRight.data : -1;
            System.out.println("nextRight of " + tree.root.right.data + " is "
                    + c);
            int d = tree.root.left.left.nextRight != null ?
                    tree.root.left.left.nextRight.data : -1;
            System.out.println("nextRight of " + tree.root.left.left.data + " is "
                    + d);
        }
}

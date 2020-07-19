package tree;

public class CountTheNumberOfBinarySearchTreesPresentInABinaryTree {
    // Binary tree node
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    };

    // Information stored in every
    // node during bottom up traversal
    static class Info {

        // Stores the number of BSTs present
        int numBST;

        // Max Value in the subtree
        int max;

        // Min value in the subtree
        int min;

        // If subtree is BST
        boolean isBST;

        Info(int a, int b, int c, boolean d)
        {
            numBST = a;
            max = b;
            min = c;
            isBST = d;
        }
        Info()
        {
        }
    };

    // Returns information about subtree such as
    // number of BST's it has
    static Info numberOfBST(Node root)
    {
        // Base case
        if (root == null)
        {
            return new Info(0, Integer.MIN_VALUE,
                    Integer.MAX_VALUE, true);
        }

        // If leaf node then return
        // from function and store
        // information about the leaf node
        if (root.left == null && root.right == null)
        {
            return new Info(1, root.data, root.data, true);
        }

        // Store information about the left subtree
        Info L = numberOfBST(root.left);

        // Store information about the right subtree
        Info R = numberOfBST(root.right);

        // Create a node that has to be returned
        Info bst = new Info();
        bst.min = Math.min(root.data, (Math.min(L.min, R.min)));
        bst.max = Math.max(root.data, (Math.max(L.max, R.max)));

        // If whole tree rooted under the
        // current root is BST
        if (L.isBST && R.isBST && root.data > L.max && root.data < R.min) {

            // Update the number of BSTs
            bst.isBST = true;
            bst.numBST = 1 + L.numBST + R.numBST;
        }

        // If the whole tree is not a BST,
        // update the number of BSTs
        else {
            bst.isBST = false;
            bst.numBST = L.numBST + R.numBST;
        }

        return bst;
    }

    // Driver code
    public static void main(String args[])
    {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.right.right = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        System.out.print(numberOfBST(root).numBST);
    }
}

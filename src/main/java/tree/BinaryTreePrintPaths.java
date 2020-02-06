package tree;

//Java program for different tree traversals

class BinaryTreePrintPaths
{
    // Root of Binary Tree
    Node root;

    BinaryTreePrintPaths()
    {
     root = null;
    }

    void printPaths(Node node)
    {
     int path[] = new int[1000];
     printPathsRecur(node, path, 0);
    }

    void printArray(int ints[], int len)
    {
     int i;
     for (i = 0; i < len; i++)
     {
         System.out.print(ints[i] + " ");
     }
     System.out.println("");
    }

    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
    void printPathsRecur(Node node, int[] paths, int length)
    {
     if (node == null)
     {
         return;
     }

     paths[length] = node.data;
     length++;
     if(node.left == null && node.right == null)
     {
         printArray(paths, length);
     }
     else
     {
         printPathsRecur(node.left, paths, length);
         printPathsRecur(node.right, paths, length);
     }
    }

    void printPathsRecur(Node node, String paths)
    {
        if (node == null)
        {
            return;
        }

        paths = paths + "," + node.data;
        if (node.left == null && node.right == null)
        {
            System.out.println(paths);
        } else
        {
            printPathsRecur(node.left, paths);
            printPathsRecur(node.right, paths);
        }
    }

    /* Given a binary tree, print its nodes in inorder*/
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


    // Wrappers over above recursive functions
    void printInorder()    {     printInorder(root);   }

    // Driver method
    public static void main(String[] args)
    {
     BinaryTreePrintPaths tree = new BinaryTreePrintPaths();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);

     /* convert tree to its mirror */
         tree.printPaths(tree.root);
        tree.printPathsRecur(tree.root, "");
    }
}
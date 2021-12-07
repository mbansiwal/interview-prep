package tree;

/**
 * Date 03/22/2016
 * @author Tushar Roy
 *
 * from some starting node to any node in the tree along the parent-child connections.
 * 
 * Time complexity O(n)
 * Space complexity depends on depth of tree.
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    Node root;
    
    public int maxPathSum(Node root) {
		maxPathSumUtil(root);
//		maxSumPath(root);
       return max;
    }

    private int maxPathSumUtil(Node node) 
    {
       if(node == null)
       {
    	   return 0;
       }
       
       int leftSum = maxPathSumUtil(node.left);
       int rightSum = maxPathSumUtil(node.right);
       
       if(leftSum < 0)
       {
    	   leftSum = 0;
       }
       
       if(rightSum < 0)
       {
    	   rightSum = 0;
       }
       max = Math.max(max, node.data + leftSum + rightSum);
       
       return node.data + Math.max(leftSum, rightSum);
    }
    
	private void maxSumPath(Node node)
	{
		maxSumPathUtil(node, new StringBuilder(""));
		System.out.println();
	}

	private int maxSumPathUtil(Node node, StringBuilder paths)
	{
		if (node == null)
		{
			return 0;
		}
		paths.append("," + node.data);
		StringBuilder leftSb = new StringBuilder("");
		StringBuilder rightSb = new StringBuilder("");
		int leftSum = maxSumPathUtil(node.left, leftSb);
		int rightSum = maxSumPathUtil(node.right, rightSb);
		// paths.append(leftSb).append(rightSb);
		int sum = leftSum + node.data + rightSum;
		if (sum > max)
		{
			max = sum;
			System.out.println(paths.toString() + leftSb.toString() + rightSb.toString());
		}
		if (leftSum > rightSum)
		{
			paths.append(leftSb);
		} else
		{
			paths.append(rightSb);
		}
		return node.data + Math.max(leftSum, rightSum);
	}

    public static void main(String[] args) {
    	BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
		tree.root.right = new Node(15);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
		// System.out.println("maximum path sum is : " +
		// tree.maxPathSum(tree.root));
		tree.maxSumPath(tree.root);
	}
}

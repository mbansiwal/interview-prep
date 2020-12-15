package tree;

/**
 * https://leetcode.com/problems/maximum-binary-tree/submissions/
 * 
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

 * @author mbbansiw
 *
 */
public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length);
    }

	private TreeNode construct(int[] nums, int low, int high) {
		if(low == high)
		{
			return null;
		}
		int maxIndex = maxIndex(nums, low, high);
		TreeNode node = new TreeNode(nums[maxIndex]);
		node.left = construct(nums, low, maxIndex);
		node.right = construct(nums, maxIndex+1, high);
		return node;
		
	}
	
	private int maxIndex(int[] nums, int low, int high) {
		int max = low;
		for (int i = low; i < high; i++) {
			if(nums[max] < nums[i]) {
				max = i;
			}
		}
		return max;
	}
}

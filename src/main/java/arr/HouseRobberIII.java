package arr;

import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/house-robber-iii
 * 
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that all houses in this place form a binary tree. 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 
 *  
 * @author mbbansiw
 *
 */

public class HouseRobberIII {
	private class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
	}
	
	Map<TreeNode, Integer> robbedMap = new HashMap<>();
    Map<TreeNode, Integer> notRobbedMap = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(rob(root, false), rob(root, true));
    }
    
    private int rob(TreeNode root, boolean isParentRobbed) {
        if(root == null){
            return 0;
        }
        
        if(isParentRobbed){
            if(robbedMap.containsKey(root)){
                return robbedMap.get(root);
            }
            
            int amount = rob(root.left, false) + rob(root.right, false);
            robbedMap.put(root, amount);
            return amount;
        }else {
            if(notRobbedMap.containsKey(root)){
                return notRobbedMap.get(root);
            }
            
            int robbedAmount = root.val + rob(root.left, true) + rob(root.right, true);
            int notRobbedAmount = rob(root.left, false) + rob(root.right, false);
            int amount = Math.max(robbedAmount, notRobbedAmount);
            notRobbedMap.put(root, amount);
            return amount;
        }
    }

	public static void main(String[] args) {
		int[] nums = { 2, 3, 2 };
		TreeNode node = null;
		System.out.println(new HouseRobberIII().rob(node));
	}
}

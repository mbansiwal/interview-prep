package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree {
	int maxWidth = Integer.MIN_VALUE;
	public int widthOfBinaryTree2(Node root) {
		widthOfBinaryTree2Util(root, 0, 0, new HashMap<>());
		return maxWidth;
	}
	
	public void widthOfBinaryTree2Util(Node root, int index, int level, Map<Integer, Integer> map) {
		if(root == null) {
			return;
		}
		if(!map.containsKey(level)) {
			map.put(level, index);
		} else {
			maxWidth = Math.max(maxWidth, index - map.get(level)+1);
		}
		widthOfBinaryTree2Util(root.left, 2*index+1, level+1, map);
		widthOfBinaryTree2Util(root.right, 2*index+2, level+1, map);
	}
	
	public int widthOfBinaryTree(Node root) {
		int size = height(root);
		Integer[] arr = new Integer[(int)Math.pow(2, size) + 1];
		treeToArray(root, arr, 0);
		System.out.println(Arrays.toString(arr));
	    
		int lastIndex = arr.length-1;
		while(arr[lastIndex] == null) {
			--lastIndex;
		}
		
		int parent = 0;
		if(lastIndex%2 == 0) {
			parent = (lastIndex - 2)/2;
		} else {
			parent = (lastIndex - 1)/2;
		}
		
		while(arr[parent+1] == null) {
			parent++;
		}
		return lastIndex-parent; 
	}
	
	
	
	private void treeToArray(Node node, Integer[] arr, int index) {
		if(node == null) {
			return;
		}
		
		arr[index] = node.data;
		treeToArray(node.left, arr, 2*index+1);
		treeToArray(node.right, arr, 2*index+2);
	}
	
	private int height(Node node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + Math.max(height(node.left), height(node.right)); 
	}
	
	public static void main(String[] args) {
		/**
		 * 1
         /   \
        3     2
       / \     \  
      5   3     9 
		 */
		
//		Node node = new Node(1);
//		node.left = new Node(3);
//		node.right = new Node(2);
//		
//		node.left.left = new Node(5);
//		node.left.right = new Node(3);
//		
//		node.right.right = new Node(9);
//		
//		System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(node));
		
//		Node node = new Node(1);
//		node.left = new Node(3);
//		
//		node.left.left = new Node(5);
//		node.left.right = new Node(3);
//		System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(node));
		
//		Node node = new Node(1);
//		node.left = new Node(3);
//		node.right = new Node(2);
//		
//		node.left.left = new Node(5);
//		System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(node));	
		
		
		Node node = new Node(1);
		node.left = new Node(3);
		node.right = new Node(2);
		
		node.left.left = new Node(5);
		node.left.right = new Node(3);
		
		node.right.right = new Node(9);
		
		node.left.left.left = new Node(6);
		node.right.right.right = new Node(7);
		System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree2(node));
	}
}

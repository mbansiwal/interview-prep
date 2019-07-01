package tree;

import java.util.Stack;

public class PreOrderArrayIsBST 
{
	public static boolean canRepresentBST(int[] arr)
	{
		Stack<Integer> stack = new Stack<>();
		
		int minimalAcceptableValue = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) 
		{
			if(arr[i] < minimalAcceptableValue)
			{
				return false;
			}
			
			while(!stack.isEmpty() && stack.peek() < arr[i])
			{
				minimalAcceptableValue = stack.pop();
			}
			
			stack.push(arr[i]);
		}
		return true;
	}
	
	public static void main(String[] args) {
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if (canRepresentBST(pre1) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        int n1 = pre2.length;
        if (canRepresentBST(pre2) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
	}
}

package ds;

import java.util.Stack;

public class BalancedString {
	static boolean isBalanced(String str)
	{
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) 
		{
			switch(arr[i])
			{
				case '{':
					stack.push(arr[i]);
					break;
				case '[':
					stack.push(arr[i]);
					break;
				case '}':
						if(stack.pop() != '{')
						{
							return false;
						}
						break;
				case ']':
					if(stack.pop() != '[')
					{
						return false;
					}
					break;
			}
		}
		
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		System.out.println(isBalanced("[nice{picture}]"));
		System.out.println(isBalanced("[nice{picture}"));
	}
}

package google;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 * 
 * Given two sequences pushed and popped with distinct values, return true if
 * and only if this could have been the result of a sequence of push and pop
 * operations on an initially empty stack.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1] Output: true Explanation:
 * We might do the following sequence: push(1), push(2), push(3), push(4), pop()
 * -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1 Example 2:
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2] Output: false Explanation:
 * 1 cannot be popped before 2.
 * 
 * Intuition
 * 
 * We have to push the items in order, so when do we pop them?
 * 
 * If the stack has say, 2 at the top, then if we have to pop that value next,
 * we must do it now. That's because any subsequent push will make the top of
 * the stack different from 2, and we will never be able to pop again.
 * 
 * Algorithm
 * 
 * For each value, push it to the stack.
 * 
 * Then, greedily pop values from the stack if they are the next values to pop.
 * 
 * At the end, we check if we have popped all the values successfully.
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int N = pushed.length;
		Stack<Integer> stack = new Stack();

		int j = 0;
		for (int x : pushed) {
			stack.push(x);
			while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}

		return j == N;
	}
}

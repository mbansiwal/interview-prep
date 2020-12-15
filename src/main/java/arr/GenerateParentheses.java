package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateAll(new char[2 * n], 0, result);
		System.out.println(result);
		return result;
	}

	public List<String> generateParenthesisOptimum(int n) {
		List<String> result = new ArrayList<>();
		generateAll(new char[2 * n], 0, 0, 0, result, n);
		System.out.println(result);
		return result;
	}

	public void generateAll(char[] array, int pos, int open, int close, List<String> result, int n) {
		if (array.length == pos) {
			result.add(new String(array));
			return;
		}
		if (open < n) {
			array[pos] = '(';
			generateAll(array, pos + 1, open + 1, close, result, n);
		}
		if (close < open) {
			array[pos] = ')';
			generateAll(array, pos + 1, open, close + 1, result, n);
		}
	}

	public void generateAll(char[] array, int pos, List<String> result) {
		if (pos == array.length) {
			if (isValid(array)) {
				result.add(new String(array));
			}
		} else {
			array[pos] = '(';
			generateAll(array, pos + 1, result);
			array[pos] = ')';
			generateAll(array, pos + 1, result);
		}
	}

	public void generateParenthesis(String str, List<String> result) {
		if (str.length() == 6) {
			result.add(str);
		}
		generateParenthesis("(" + str, result);
		generateParenthesis(str + "(", result);
		generateParenthesis(str, result);
	}

	private boolean isValid(char[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '(') {
				count++;
			} else {
				count--;
			}

			if (count < 0) {
				return false;
			}
		}
		return count == 0;
	}

	/**
	 * Time and Space Complexity : O(\dfrac{4^n}{\sqrt{n}}) O(4^n/sqrt(n))
	 * 
	 * ​ ). The analysis is similar to
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesisIntutive(int n) {
		List<String> result;
		if (n == 0) {
			result = Arrays.asList("");
		} else {
			result = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			for (String left : generateParenthesisIntutive(i)) {
				for (String right : generateParenthesisIntutive(n - i - 1)) {
					result.add("(" + left + ")" + right);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new GenerateParentheses().generateParenthesisOptimum(3);
		System.out.println(new GenerateParentheses().generateParenthesisIntutive(3));
	}
}

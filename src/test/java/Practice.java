import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		System.out.println("abcde".substring(1, 1 + 4));
//		System.out.println(minDeletions("aab"));
//		System.out.println(minDeletions("aaabbbcc"));
//		
//		System.out.println(new Practice().solution(10, 85, 30)); 
//		System.out.println(new Practice().findXor(4, 1, 3, 2));
		System.out.println(new Practice().longestValidParentheses(")()())"));
	}

	public static int minDeletions(String s) {
		Integer[] chars = new Integer[26];
		Arrays.fill(chars, 0);
		int deletions = 0;

		// character count
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}

		// ascending sort
		Arrays.sort(chars, Collections.reverseOrder());

		int l = chars[0];

		// main logic for deletion
		for (int i = 1; i < 26; i++) {
			if (chars[i] != 0) {
				while (l <= chars[i]) {
					chars[i]--;
					deletions++;
				}
				if (chars[i] > 0) {
					l = chars[i];
				}
			}
		}

		return deletions;
	}
	
	private void convert(StringBuilder sb, int n){
        if(n > 1){
            convert(sb, n >> 1);
        }
        sb.append(n & 1);
    }
    public int solution(int N) {
        StringBuilder sb = new StringBuilder();
        convert(sb, N);
        char[] str = sb.toString().toCharArray();

        int maxZeros = 0;
        int startOne = -1;
        for(int i=0; i < str.length; ++i){
            if(str[i] == '1'){
                if(startOne == -1){
                    startOne = i;
                } else{
                    maxZeros = Math.max(maxZeros, i - startOne - 1);
                    startOne = i;
                }
            }
        }

        return maxZeros;
    }
    
    public int solution(int x, int y, int d) {
        int distance = y - x;
        float division = (float)distance / d;
        int jumps = (int)division;
        if((division - jumps) > 0.0){
            jumps++;
        }
        return jumps;
    }
    
    public int findXor(int... A) {
        // write your code in Java SE 8
        if(A.length == 0){
            return 0;
        }
        int xor = 1 ^ A[0];
        for(int i=1; i < A.length; ++i){
            xor = (i+1) ^ xor ^ A[i];
        }
        return xor == 0 ? 1: 0;
    }
    
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i=0; i < n; ++i){
            if(arr[i] == ']'){
                String temp = "";
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    temp = stack.pop() + temp;
                }
                stack.pop();
                String number = stack.pop();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                	number = stack.pop() + number;
                }
                int numberOfTimes = Integer.parseInt(number);
                StringBuilder sb = new StringBuilder();
                for(int j=0; j < numberOfTimes; ++j){
                    sb.append(temp);
                }
                stack.push(sb.toString());
            } else {
            	stack.push("" + arr[i]);
            }
        }
        
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()){
            output.insert(0, stack.pop());
        }
        return output.toString();
    }
    
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] table = new int[n][n];
        
        char[] str = s.toCharArray();
        
        for(int i=0; i < n; ++i){
            table[i][i] = 1;
        }   
        for(int l=2; l <= n; ++l){
            for(int i=0; i < n - l + 1; ++i){
                int j = i + l - 1;
                if(isPalindrom(str, i, j)){
                    table[i][j] = 0;
                } else{
                   int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++)
					{
						min = Math.min(min, table[i][k] + table[k + 1][j]);
					}
					table[i][j] = 1 + min;
                }
            }
        }
        return table[0][n-1];
    }
    
    private boolean isPalindrom(char[] str, int i, int j){
        while (i < j)
		{
			if (str[i] != str[j])
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
    }
    
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for(int i=0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                } else{
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}

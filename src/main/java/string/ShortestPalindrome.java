package string;

public class ShortestPalindrome {
	static String shortestPalindrome(String s)
	{
		String reverse = new StringBuilder(s).reverse().toString();
		String input = new StringBuilder(s).append("#").append(reverse).toString();
		
		int n = input.length();
		int[] table = new int[n];
		char[] arr = input.toCharArray();
		for (int i = 1; i < n; i++) {
			int j = table[i-1];
			while(j > 0 && arr[i] != arr[j]) {
				j = table[j-1];
			}
			if(arr[i] == arr[j]) {
				j++;
			} 
			table[i] = j;
		}
		
		return reverse.substring(0, s.length() - table[n-1]) + s ;
	}
	
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("aacecaaa"));
	}
}

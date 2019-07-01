package dp.palindrom;

public class Pallendrome
{
	public static boolean isPalindrome(String word)
	{
		int length = word.length();
		int left = 0;
		int right = length - 1;
		char[] text = word.toLowerCase().toCharArray();
		while (left < right)
		{
			if (text[left] != text[right])
			{
				return false;
			} else
			{
				left++;
				right--;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(isPalindrome("Deleveled"));
		System.out.println(isPalindrome("adam"));
		System.out.println(isPalindrome("madaM"));
	}
}

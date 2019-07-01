package string;

public class NoOfVowels
{
	public int findNumberOfVowels(char[] str)
	{
		int number = 0;
		int n = str.length;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
		{
			if (i == 0)
			{
				arr[i] = n;
			} else
			{
				arr[i] = n - i + arr[i - 1] - i;
			}
		}

		for (int i = 0; i < n; i++)
		{
			if (isVowel(str, i))
			{
				number += arr[i];
			}
		}

		return number;
	}

	private boolean isVowel(char[] str, int i)
	{
		if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u')
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new NoOfVowels().findNumberOfVowels("abc".toCharArray()));
		System.out.println(new NoOfVowels().findNumberOfVowels("daceh".toCharArray()));
	}
}

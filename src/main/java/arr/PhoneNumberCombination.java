package arr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination
{
	Map<Character, String> phone = new HashMap<Character, String>()
	{
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};

	List<String> output = new ArrayList<String>();

	public void backTrack(String digits, String combinations)
	{
		if (digits.length() == 0)
		{
			output.add(combinations);
			return;
		}

		String currentLetters = phone.get(digits.charAt(0));
		for (int i = 0; i < currentLetters.length(); i++)
		{
			backTrack(digits.substring(1), combinations + currentLetters.charAt(i));
		}
	}

	public List<String> letterCombinations(String digits)
	{
		if (digits.length() > 0)
		{
			backTrack(digits, "");
		}
		return output;
	}

	public static void main(String[] args)
	{
		System.out.println(new PhoneNumberCombination().letterCombinations("23"));
	}
}

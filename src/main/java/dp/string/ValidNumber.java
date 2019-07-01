package dp.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber
{
	public static void main(String[] args)
	{
		String input = ".1";
		String patternFormat = "[+-]?([0-9]+)?([\\.])?([0-9]+)?([eE][-+]?[0-9]+)?";
		Pattern pattern = Pattern.compile(patternFormat);
		Matcher matcher = pattern.matcher(input.trim());
		if (matcher.find() && matcher.group().equals(input.trim()))
		{
			System.out.println(true);
		}
		System.out.println(pattern.matcher(input.trim()).matches());
	}
}

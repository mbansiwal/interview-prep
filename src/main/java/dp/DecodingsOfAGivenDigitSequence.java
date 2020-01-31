package dp;

/**
 * Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the
 * number of possible decodings of the given digit sequence.
 * 
 * Examples:
 * 
 * Input: digits[] = "121" Output: 3 // The possible decodings are "ABA", "AU",
 * "LA"
 * 
 * Input: digits[] = "1234" Output: 3 // The possible decodings are "ABCD",
 * "LCD", "AWD" An empty digit sequence is considered to have one decoding. It
 * may be assumed that the input contains valid digits from 0 to 9 and there are
 * no leading 0’s, no extra trailing 0’s and no two or more consecutive 0’s.
 * 
 * @author mbansiwal
 *
 */
public class  DecodingsOfAGivenDigitSequence
{
	static int countDecodingDP(char[] digits, int n)
	{
		int count[] = new int[n + 1]; // A table to store results of subproblems
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++)
		{
			count[i] = 0;

			// If the last digit is not 0, then last digit must add to
			// the number of words
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];

			// If second last digit is smaller than 2 and last digit is
			// smaller than 7, then last two digits form a valid character
			if (digits[i - 2] < '2' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}

	static int countDecodingDPOptimal(char[] digits, int n)
	{
		int[] table = new int[n];

		if(n < 2){
			return 1;
		}
		table[0] = 1;

		if(isValid(digits[0], digits[1])){
			table[1] = 2;
		} else{
			table[1] = 1;
		}

		for (int i=2; i < n; ++i){
			if(digits[i] != '0'){
				table[i] = table[i-1];
			}

			if(isValid(digits[i-1], digits[i])){
				table[i] += table[i-2];
			}
		}

		return table[n-1];
	}

	private static boolean isValid(int firstDigit, int secondDigit){
		if((firstDigit > '0' && firstDigit < '2') || (firstDigit == '2' && secondDigit <= '6')){
			return true;
		}
		return false;
	}

	// Driver program to test above function
	public static void main(String[] args)
	{
		char digits[] = "1234".toCharArray();
		System.out.println("Count is " + countDecodingDP(digits, digits.length));
		System.out.println("Count is " + countDecodingDPOptimal(digits, digits.length));

		char digits2[] = "12".toCharArray();
		System.out.println("Count is " + countDecodingDP(digits2, digits2.length));
		System.out.println("Count is " + countDecodingDPOptimal(digits2, digits2.length));

		char digits3[] = "102".toCharArray();
		System.out.println("Count is " + countDecodingDP(digits3, digits3.length));
		System.out.println("Count is " + countDecodingDPOptimal(digits3, digits3.length));

	}
}

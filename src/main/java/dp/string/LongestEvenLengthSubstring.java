package dp.string;

public class LongestEvenLengthSubstring
{
	static int findLength2(char[] str, int n)
	{
		int maxLength = 0;
		for (int i = 0; i < n - 1; i++)
		{
			int left = i;
			int right = i + 1;
			int leftSum = 0;
			int rightSum = 0;
			while (left >= 0 && right < n)
			{
				leftSum += str[left] - '0';
				rightSum += str[right] - '0';
				if (leftSum == rightSum)
				{
					maxLength = Math.max(maxLength, right - left + 1);
				}
				left--;
				right++;
			}
		}
		return maxLength;
	}
	
	
	
	
	

	static int findLength(char[] str, int n)
	{
		int ans = 0; // Initialize result

		// Consider all possible midpoints one by one
		for (int i = 0; i < n - 1; i++)
		{
			/*
			 * For current midpoint 'i', keep expanding substring on both sides, if sum of both sides becomes equal
			 * update ans
			 */
			int l = i, r = i + 1;

			/* initialize left and right sum */
			int lsum = 0, rsum = 0;

			/* move on both sides till indexes go out of bounds */
			while (r < n && l >= 0)
			{
				lsum += str[l] - '0';
				rsum += str[r] - '0';
				if (lsum == rsum)
				{
					ans = Math.max(ans, r - l + 1);
				}
				l--;
				r++;
			}
		}
		return ans;
	}

	public static void main(String[] args)
	{
		String str = "153803";
		System.out.println("Length of the substring is " + findLength2(str.toCharArray(), str.length()));

		str = "1538023";
		System.out.println("Length of the substring is " + findLength2(str.toCharArray(), str.length()));

		str = "123123";
		System.out.println("Length of the substring is " + findLength2(str.toCharArray(), str.length()));

	}

}

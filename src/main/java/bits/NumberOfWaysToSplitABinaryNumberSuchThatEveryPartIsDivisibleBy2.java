package bits;

/**
 * https://www.geeksforgeeks.org/number-of-ways-to-split-a-binary-number-such-that-every-part-is-divisible-by-2/?ref=rp
 * Given a binary string S, the task is to find the number of ways to split it into parts such that every part is divisible by 2.
 *
 * Examples:
 *
 * Input: S = “100”
 * Output: 2
 * There are two ways to split the string:
 * {“10”, “0”} and {“100”}
 *
 * Input: S = “110”
 * Output: 1
 */
public class NumberOfWaysToSplitABinaryNumberSuchThatEveryPartIsDivisibleBy2 {
    // Function to return the required count
    static int cntSplits(String s)
    {
        int n = s.length();
        // If the splitting is not possible
        if (s.charAt(n - 1) == '1')
        {
            return 0;
        }

        // To store the count of zeroes
        int numberOfZeros = 0;

        // Counting the number of zeroes
        for (int i = 0; i < n; i++)
        {
            numberOfZeros += (s.charAt(i) == '0') ? 1 : 0;
        }

        // Return the final answer
        return (int)Math.pow(2, numberOfZeros - 1);
    }

    // Driver code
    public static void main(String []args)
    {
        String s = "10010";

        System.out.println(cntSplits(s));
    }
}

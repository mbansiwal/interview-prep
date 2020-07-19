package math;

/**
 * https://www.geeksforgeeks.org/count-of-distinct-graphs-that-can-be-formed-with-n-vertices/
 *
 * Given an integer N which is the number of vertices.
 * The task is to find the number of distinct graphs that can be formed.
 * Since the answer can be very large, print the answer % 1000000007.
 *
 * Examples:
 *
 * Input: N = 3
 * Output: 8
 *
 * Input: N = 4
 * Output: 64
 */
public class CountOfDistinctGraphs {
    static final int MOD = (int)1e9 + 7;

    // Function to return (x^y) % MOD
    // in O(log(y))
    static long power(long x,
                      long y)
    {
        long res = 1;
        while (y > 0)
        {
            if ((y & 1) != 0)
                res = (res * x) % MOD;
            x = (x * x) % MOD;
            y /= 2;
        }
        return res;
    }

    // Function to return the count of distinct
    // graphs possible with n vertices
    static long countGraphs(int n)
    {

        // Maximum number of edges for a
        // graph with n vertices
        long x = n * (n - 1) / 2;

        // Function to calculate
        // (2^x) % mod
        return power(2, x);
    }

    // Driver code
    public static void main (String[] args)
    {
        int n = 5;

        System.out.println(countGraphs(n));
    }
}

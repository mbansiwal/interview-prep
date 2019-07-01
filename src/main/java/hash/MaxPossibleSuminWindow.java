package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Maximum possible sum of a window in an array such that elements of same
 * window in other array are unique Given two arrays A and B of equal number of
 * elements. Task is to find the maximum sum possible of a window in array B
 * such that elements of same window in A[] are unique.
 * 
 * Examples:
 * 
 * Input : A = [0, 1, 2, 3, 0, 1, 4] B = [9, 8, 1, 2, 3, 4, 5] Output : sum = 20
 * The maximum sum possible in B[] such that all corresponding elements in A[]
 * are unique is (9+8+1+2) = 20.
 * 
 * Input : A = [0, 1, 2, 0, 2] B = [5, 6, 7, 8, 2] Output :sum = 21
 * 
 * @author mbansiwal
 *
 */
public class MaxPossibleSuminWindow
{
	// Function to return maximum sum of window
	// in A[] according to given constraints.
	static int returnMaxSum(int A[], int B[], int n)
	{

		// Map is used to store elements
		// and their counts.
		Set<Integer> mp = new HashSet<Integer>();

		int result = 0; // Initialize result

		// calculating the maximum possible
		// sum for each subarray containing
		// unique elements.
		int curr_sum = 0, curr_begin = 0;
		for (int i = 0; i < n; ++i)
		{
			// Remove all duplicate
			// instances of A[i] in
			// current window.
			while (mp.contains(A[i]))
			{
				mp.remove(A[curr_begin]);
				curr_sum -= B[curr_begin];
				curr_begin++;
			}

			// Add current instance of A[i]
			// to map and to current sum.
			mp.add(A[i]);
			curr_sum += B[i];

			// Update result if current
			// sum is more.
			result = Integer.max(result, curr_sum);

		}
		return result;
	}

	// Driver Code to test above method
	public static void main(String[] args)
	{
		int A[] =
		{
				4, 0, 1, 2, 3, 0, 1, 4
		};
		int B[] =
		{
				4, 9, 8, 1, 2, 3, 25, 5
		};
		int n = A.length;
		System.out.println(returnMaxSum(A, B, n));
		
		int A1[] = { 0, 1, 2, 3, 0, 2 };
		int B1[] = { 9, 8, 1, 2, 3, 25 };
		System.out.println(returnMaxSum(A1, B1, A1.length));
	}
}

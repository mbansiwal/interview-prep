package arr;

/**
 * https://leetcode.com/problems/h-index/
 * 
 * Given an array of citations (each citation is a non-negative integer) of a researcher, 
 * write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: 
"A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * 
 * @author mbbansiw
 *
 */
public class HIndex {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int table[] = new int[n+1];
		
		for (int i = 0; i < n; i++) {
			if(citations[i] < n) {
				table[citations[i]] += 1;
			} else {
				table[n] += 1;
			}
		}
		
        // Go through the count[] array from last index down to 0, trying 
        // successively smaller values for h.  Looping from high to low 
        // possible values for h, will find the highest valid value for 
        // h.  While descending through the count array, add the count 
        // from the next higher index in the count array, which will 
        // convert the current counts[h] value to become a count of 
        // papers with h or more citations.  This is slightly confusing 
        // because h is used as both an index and a value to compare to 
        // the array value at that index.  The "units" for h feel 
        // inconsistent.
		int sum = 0;
		for (int i = n; i >= 0; --i) {
			sum += table[i];
			
			if(sum >= i) {
				return i;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,0,6,1,5};
		System.out.println(new HIndex().hIndex(arr));
	}
}

package arr;

/**
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 * 
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
Examples :

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
  
 * @author mbbansiw
 *
 */
public class FindTheMaximumInIandJ {
	int maxIndexDiff(int arr[]) 
    { 
		int n = arr.length;
		if(arr == null || n == 0) {
			return 0;
		}
		
		int lowArr[] = new int[n];
		lowArr[0] = arr[0];
		for (int i = 1; i < n; i++) {
			lowArr[i] = Math.min(lowArr[i-1], arr[i]);
		}
		
		int highArr[] = new int[n];
		highArr[n-1] = arr[n-1];
		for (int i = n-2; i >= 0; --i) {
			highArr[i] = Math.max(highArr[i+1], arr[i]);
		}
		
		int maxDiff = -1;
		int i = 0;
		int j = 0;
		while(i < n && j < n) {
			if(lowArr[i] < highArr[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}
		
		return maxDiff;
    }
	
	public static void main(String[] args) {
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		System.out.println(new FindTheMaximumInIandJ().maxIndexDiff(arr));
	}
}

package arr;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
 * 
 * @author mbbansiw
 *
 */
public class RearrangeArrayArrIj {
	public static void rearrangeNaive(int arr[]) 
    { 
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[arr[i]%n] += i*n;
		}
		
		for (int i = 0; i < n; i++) {
			arr[i]/=n;
		}
    }
	
	public static void main(String[] args) {
		int arr[] = { 2, 0, 1, 4, 5, 3 };
		rearrangeNaive(arr);
		System.out.println("Modified array is :" + Arrays.toString(arr)); 
	}
}

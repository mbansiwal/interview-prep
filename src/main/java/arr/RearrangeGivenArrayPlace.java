package arr;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/rearrange-given-array-place/
 * @author mbbansiw
 *
 */
public class RearrangeGivenArrayPlace {
	static void rearrange(int arr[])  
    {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] += (arr[arr[i]]%n)*n;
		}
		
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i]/n;
		}
    }
	public static void main(String[] args) {
		int arr[] = {3, 2, 0, 1};
		rearrange(arr);
		
		System.out.println(Arrays.toString(arr));
		//[1, 0, 3, 2]
	}
}

package arr;

import java.util.Arrays;
import java.util.Iterator;

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
	
	static void rearrange2(int arr[])  
    {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] + (arr[arr[i]]%n)*n;
		}
		
		for (int i = 0; i < n; i++) {
			arr[i]/=n;
		}
    }
	
	public static void main(String[] args) {
		int arr[] = {3, 2, 0, 1};
		rearrange(arr);
		
		System.out.println(Arrays.toString(arr));
		
		int arr2[] = {3, 2, 0, 1};
		rearrange2(arr2);
		
		System.out.println(Arrays.toString(arr2));
		//[1, 0, 3, 2]
	}
}

package arr;

import java.util.Arrays;

public class ReorderArrayByIndex {
	static void reorder(int arr[], int index[]) 
    {
		for (int i = 0; i < index.length; i++) {
			while(index[i] != i) {
				int tempIndex = index[index[i]];
				int tempVal = arr[index[i]];
				arr[index[i]] = arr[i];
				index[index[i]] = index[i];
				arr[i] = tempVal;
				index[i] = tempIndex;
			}
		}
    }
	
	static void reorder2(int arr[], int index[]) 
    {
		int n = index.length;
		for (int i = 0; i < n; i++) {
			arr[i] += arr[index[i]]*n;
		}
		
		for (int i = 0; i < n; i++) {
			arr[i] /= n;
		}
    }
	
	
	public static void main(String[] args) {
		int arr[] = new int[]{50, 40, 70, 60, 90}; 
	    int index[] = new int[]{3,  0,  4,  1,  2};
	    reorder(arr, index);
	    System.out.println("Reordered array is: "); 
        System.out.println(Arrays.toString(arr)); 
        System.out.println("Modified Index array is:"); 
        System.out.println(Arrays.toString(index));

		int arr2[] = new int[]{50, 40, 70, 60, 90}; 
	    int index2[] = new int[]{3,  0,  4,  1,  2};
        reorder(arr2, index2);
	    System.out.println("Reordered array is: "); 
        System.out.println(Arrays.toString(arr2)); 
        System.out.println("Modified Index array is:"); 
        System.out.println(Arrays.toString(index2));
	}
}

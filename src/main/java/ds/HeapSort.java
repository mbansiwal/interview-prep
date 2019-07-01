/**
 * 
 */
package ds;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/
 * 
 * @author mbansiwal
 *
 */
public class HeapSort 
{
	int size = 0;
	int[] arr;
	
	public HeapSort(int[] arr) 
	{
		this.size = arr.length;
		this.arr = arr;
		heapify();
	}

	public void minify(int rootIndex)
	{
		int leftIndex = 2*rootIndex+1;
		int rightIndex = 2*rootIndex+2;
		int leftElement = leftIndex < size?arr[leftIndex]:Integer.MAX_VALUE;
		int rightElement = rightIndex < size?arr[rightIndex]:Integer.MAX_VALUE;
		int smallestIndex = rootIndex;
		int smallestElement = arr[rootIndex];
		if(leftElement < smallestElement)
		{
			smallestIndex = leftIndex;
			smallestElement = leftElement;
		}
		if(rightElement < smallestElement)
		{
			smallestIndex = rightIndex;
			smallestElement = rightElement;
		}
		if(smallestIndex != rootIndex)
		{
			arr[smallestIndex] = arr[rootIndex];
			arr[rootIndex] = smallestElement;
			minify(smallestIndex);
		}
	}
	
	public void heapify()
	{
		int count = size/2;
		while(count >= 0)
		{
			minify(count);
			count--;
		}
	}
	
	public int extractMinimum()
	{
		int element = arr[0];
		arr[0] = arr[size-1];
		size--;
		minify( 0);
		return element;
	}
	
	public int relaceMinimum(int inputElement)
	{
		int element = arr[0];
		arr[0] = inputElement;
		if (element < inputElement)
		{
			minify(0);
		}
		return element;
	}
	
	public int[] sort()
	{
		int[] sortedArray = new int[arr.length];
		
		for (int i = 0; i < sortedArray.length; i++) 
		{
			sortedArray[i] = extractMinimum();
		}
		return sortedArray;
	}
	
	public static int[] sort(int[]arr, int maxDistance)
	{
		int size = arr.length;
		int[] heapArray = new int[maxDistance+1];
		for (int i = 0; i <= maxDistance; i++) 
		{
			heapArray[i] = arr[i];
		}
		System.out.println(Arrays.toString(heapArray));
		HeapSort heapSort = new HeapSort(heapArray);
		System.out.println(Arrays.toString(heapArray));
		for (int i = maxDistance+1,index=0; index < size; i++,index++) 
		{
			if(i < size)
			{
				arr[index] = heapSort.relaceMinimum(arr[i]);
			}
			else
			{
				arr[index] = heapSort.extractMinimum();
			}
			
		}
		return arr;
	}
	
	public static void main(String[] args) 
	{
		// int k = 3;
		// int arr[] = {2, 6, 3, 12, 56, 8};
		// HeapSort heapSort = new HeapSort(arr);
		// System.out.println(Arrays.toString(heapSort.sort()));
		
		int arr2[] =
		{
				6, 8, 3, 12, 56, 2
		};
		System.out.println(Arrays.toString(sort(arr2, 3)));
	}
}

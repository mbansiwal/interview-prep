package ds;

import java.util.Arrays;

public class MaxHeap {
	int size = 0;
	int[] data;
	
	public MaxHeap(int[] data) {
		this.data = data;
		size = data.length;
	}

	public void maxifyHeap(int rootIndex)
	{
		int leftIndex = 2*rootIndex + 1;
		int rightIndex = 2*rootIndex + 2;
		int root = data[rootIndex];
		int left = leftIndex<size?data[leftIndex]:Integer.MIN_VALUE;
		int right = rightIndex<size?data[rightIndex]:Integer.MIN_VALUE;
		int largestIndex = rootIndex;
		int largest = root;
		
		if(left > largest)
		{
			largest = left;
			largestIndex = leftIndex;
		}
		if(right > largest)
		{
			largest = right;
			largestIndex = rightIndex;
		}
		if(largest != root)
		{
			data[rootIndex] = largest;
			data[largestIndex] = root;
			maxifyHeap(largestIndex);
		}
	}
	
	public void initialize()
	{
		int i = (size - 1)/2;
		while(i >= 0)
		{
			maxifyHeap(i);
			i--;
		}
	}
	
	public int extractMax()
	{
		int max = data[0];
		data[0] = data[size-1];
		data[size-1] = max;
		size--;
		maxifyHeap(0);
		return max;
	}
	
	public void sort()
	{
		for (int i = 0; i < data.length; i++) 
		{
			extractMax();
		}
	}
	
	public static void main(String[] args) 
	{
		int[] data = {2,6,4,7,3,9,1,12,76,100,37};
		MaxHeap maxHeap = new MaxHeap(data);
		maxHeap.initialize();
		maxHeap.sort();
		System.out.println(Arrays.toString(data));
	}

}

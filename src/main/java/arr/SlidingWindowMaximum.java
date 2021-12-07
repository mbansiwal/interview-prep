package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum
{
	static void printMax(int arr[], int n, int k)
	{
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < k; i++)
		{
			while (!queue.isEmpty() && (arr[i] >= arr[queue.peekLast()]))
			{
				queue.removeLast();
			}
			queue.addLast(i);
		}

		for (int i = k; i < n; i++)
		{
			System.out.print(arr[queue.peek()] + ",");
			while (!queue.isEmpty() && (queue.peekFirst() <= (i - k)))
			{
				queue.removeFirst();
			}

			while (!queue.isEmpty() && (arr[i] >= arr[queue.peekLast()]))
			{
				queue.removeLast();
			}
			queue.addLast(i);
		}
		System.out.println(arr[queue.peek()]);
	}

	public static int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<k; ++i){
            while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        
        int[] output = new int[arr.length - k + 1];
        int index = 0;
        for(int i=k; i < arr.length; ++i){
            output[index++] = arr[queue.peekFirst()];
            
            while(!queue.isEmpty() && (i - queue.peekFirst()) >= k){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]){
                queue.removeLast();
            }            
            queue.add(i);
        }
        output[index] = arr[queue.peekFirst()];

        return output;
    }
	
	public static void main(String[] args)
	{
		int[] arr1 = {1,3,-1,-3,5,3,6,7};
		printMax(arr1, arr1.length, 3);
		int arr[] =
		{
				12, 1, 78, 90, 57, 89, 56
		};
		int k = 3;
		printMax(arr, arr.length, k);
		
		int arr3[] =
		{
				1
		};
		printMax(arr3, arr3.length, 1);
		System.out.println(Arrays.toString(maxSlidingWindow(arr3,  1)));
	}
}

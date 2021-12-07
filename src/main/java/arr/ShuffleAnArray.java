package arr;

import java.util.Random;

public class ShuffleAnArray
{
	int[] nums;
	int[] original;

	public ShuffleAnArray(int[] nums)
	{
		this.nums = nums.clone();
		this.original = nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset()
	{
		nums = original.clone();
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle()
	{
		int n = nums.length;
		for (int i = 0; i < n; i++)
		{
			swap(i, randomRange(i, n));
		}
		return nums;
	}

	private void swap(int source, int target)
	{
		int temp = nums[source];
		nums[source] = nums[target];
		nums[target] = temp;
	}

	private int randomRange(int start, int end){
		return start + new Random().nextInt(end - start);
	}
}

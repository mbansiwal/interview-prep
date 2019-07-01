package arr;

import java.util.Arrays;

public class SumOf3ClosetSum
{
	public static int threeSum(int[] nums, int target)
	{
		int min = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++)
		{
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right){
				int subsetSum = nums[i] + nums[left] + nums[right];
				int delta = Math.abs(subsetSum - target);

				if (subsetSum == target)
				{
					return subsetSum;
				}

				if (delta < min)
				{
					result = subsetSum;
					min = delta;
				}

				if (subsetSum < target)
				{
					left++;
				} else
				{
					right--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[] nums =
		{
				-1, 2, 1, -4
		};
		System.out.println(threeSum(nums, 1));
	}
}

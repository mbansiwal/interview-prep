package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3
{
	public static List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> subsets = new ArrayList<>();
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length - 2; i++)
		{
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right){
				int subsetSum = nums[i] + nums[left] + nums[right];
				if (subsetSum == sum)
				{
					List<Integer> currentSubset = Arrays.asList(nums[i], nums[left], nums[right]);
					if (!subsets.contains(currentSubset))
					{
						subsets.add(currentSubset);
					}
					left++;
					right--;
				}
				else if (subsetSum < sum)
				{
					left++;
				} else
				{
					right--;
				}
			}
		}

		return subsets;
	}

	public static void main(String[] args)
	{
		int[] nums =
		{
				-2, 0, 1, 1, 2
		};
		System.out.println(threeSum(nums));
	}
}

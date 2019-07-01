package arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateSubsets
{
	public List<List<Integer>> subsets(int[] nums)
	{
		Set<List<Integer>> subsets = new HashSet<>();
		int n = nums.length;
		for (int i = 0; i < n; i++)
		{
			add(subsets, nums, 0, i, n);
			add(subsets, nums, i + 1, n - 1, n);
			add(subsets, nums, i, n - 1, n);
		}
		add(subsets, nums, n % 2, n % 2, n);

		return new ArrayList<>(subsets);
	}

	private void add(Set<List<Integer>> subsets, int[] nums, int start, int end, int n)
	{
		List<Integer> numbers = subset(nums, start, end, n);
		if (!numbers.isEmpty())
		{
			subsets.add(numbers);
		}
	}
	public List<Integer> subset(int[] nums, int start, int end, int n)
	{
		List<Integer> elements = new ArrayList<>();
		for (int i = start; i <= end; i++)
		{
			elements.add(nums[i]);
		}
		return elements;
	}

	public static void main(String[] args)
	{
		int nums[] =
		{
				1, 2, 3
		};
		System.out.println(new GenerateSubsets().subsets2(nums));
	}

	public List<List<Integer>> subsets2(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<>();
		subsets2Back(nums, list, new ArrayList<>(), 0);
		return list;
		
	}

	public void subsets2Back(int[] nums, List<List<Integer>> result, List<Integer> temp, int start)
	{
		result.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++)
		{
			temp.add(nums[i]);
			subsets2Back(nums, result, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}

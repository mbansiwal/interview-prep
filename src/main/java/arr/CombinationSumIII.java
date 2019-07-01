package arr;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII
{
	public List<List<Integer>> combinationSum3(int k, int target)
	{
		List<List<Integer>> allElements = new ArrayList<>();
		combinationSum(k, target, 1, new ArrayList<>(), allElements);
		return allElements;
	}

	public void combinationSum(int k, int target, int start, List<Integer> elements, List<List<Integer>> allElements)
	{
		if (target < 0 || elements.size() > k)
		{
			return;
		}
		if (target == 0 && elements.size() == k)
		{
			allElements.add(new ArrayList<>(elements));
		}

		for (int i = start; i < 10; ++i)
		{
			if (target >= i)
			{
				elements.add(i);
				combinationSum(k, target - i, i + 1, elements, allElements);
				elements.remove(elements.size() - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new CombinationSumIII().combinationSum3(3, 7));
		System.out.println(new CombinationSumIII().combinationSum3(3, 9));
	}
}

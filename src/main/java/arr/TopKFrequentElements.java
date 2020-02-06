package arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements
{
	class Element
	{
		int number;
		int count;

		public Element(int number, int count)
		{
			super();
			this.number = number;
			this.count = count;
		}
	}

	public List<Integer> topKFrequent2(int[] nums, int k)
	{
		Map<Integer, Integer> count = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; ++i)
		{
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
		}

		java.util.PriorityQueue<java.util.Map.Entry<Integer, Integer>> queue = new java.util.PriorityQueue<>(k,
				(o1, o2) -> o2.getValue() - o1.getValue());

		Iterator<java.util.Map.Entry<Integer, Integer>> itr = count.entrySet().iterator();
		for (int i = 0; i < k; i++)
		{
			queue.offer(itr.next());
		}
		List<Integer> entries = new ArrayList<>();

		while (itr.hasNext())
		{
			queue.offer(itr.next());
		}

		while (!queue.isEmpty() && --k >=0)
		{
			entries.add(queue.poll().getKey());
		}

		System.out.println(entries);
		return entries;
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		final Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        for(int i =0; i<n; ++i){
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        
		java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(k + 1, new Comparator<Integer>()
		{
			public int compare(Integer o1, Integer o2)
			{
				return count.get(o1) - count.get(o2);
			};
		});

		Iterator<java.util.Map.Entry<Integer, Integer>> itr = count.entrySet().iterator();
		for (int i = 0; itr.hasNext(); i++)
		{
			queue.offer(itr.next().getKey());
			if (queue.size() > k)
			{
				queue.poll();
			}
		}
		List<Integer> entries = new ArrayList<>();
		
		for (int index = 0; index < k; index++)
		{
			entries.add(queue.remove());
		}
		Collections.reverse(entries);
		System.out.println(entries);
		return entries;

    }

	public static void main(String[] args)
	{
		int[] nums =
		{
				1, 1, 1, 2, 2, 3
		};
		new TopKFrequentElements().topKFrequent(nums, 2);
		new TopKFrequentElements().topKFrequent2(nums, 2);

		int[] nums2 =
		{
				1
		};
		new TopKFrequentElements().topKFrequent(nums2, 1);
		new TopKFrequentElements().topKFrequent2(nums2, 1);

		int[] num3 =
		{
				2, 3, 4, 1, 4, 0, 4, -1, -2, -1
		};
		new TopKFrequentElements().topKFrequent(num3, 2);
		new TopKFrequentElements().topKFrequent2(num3, 2);
	}
}

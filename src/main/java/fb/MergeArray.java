package fb;

import java.util.Arrays;

public class MergeArray
{
	public static void main(String[] args)
	{
		Integer[] l1 =
		{
				1, 3, 4, 12, 24, 45
		};
		Integer[] l2 =
		{
				1, 2, 3, 4, 5, 6, 7, null, null, null, null, null, null
		};

		int index = 0;
		while (l2[index] != null)
		{
			index++;
		}
		index--;
		int startIndex = index;
		int endIndex = l2.length - 1;
		while (index >= 0)
		{
			l2[endIndex] = l2[index];
			index--;
			endIndex--;
		}
		System.out.println(Arrays.toString(l2));
		int l1Index = 0;
		int l2Index = startIndex;
		int startIndexMerged = 0;
		while (l1Index < l1.length && l2Index < l2.length)
		{
			if (l1[l1Index] == l2[l2Index])
			{
				l2[startIndexMerged++] = l1[l1Index++];
				l2[startIndexMerged++] = l2[l2Index++];
			}
			else if (l1[l1Index] < l2[l2Index])
			{
				l2[startIndexMerged++] = l1[l1Index++];
			} else
			{
				l2[startIndexMerged++] = l2[l2Index++];
			}
		}
		while (l1Index < l1.length)
		{
			l2[startIndexMerged++] = l1[l1Index++];
		}
		while (l2Index < l2.length)
		{
			l2[startIndexMerged++] = l2[l2Index++];
		}
		System.out.println(Arrays.toString(l2));
	}
}

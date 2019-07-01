package arr;

public class ContainerWithMostWater
{
	public static void main(String[] args)
	{
		int[] heights =
		{
				1, 5, 4, 3
		};

		int l = 0;
		int r = heights.length - 1;
		int maxArea = 0;
		while (l < r)
		{
			maxArea = Math.max(maxArea, (r - l) * Math.min(heights[l], heights[r]));

			if (heights[l] < heights[r])
			{
				l++;
			} else
			{
				r--;
			}
		}
		System.out.println(maxArea);
	}
}

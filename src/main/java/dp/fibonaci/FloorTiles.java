package dp.fibonaci;

/**
 * Given a floor of size n x m and tiles of size 1 x m. The problem is to count
 * the number of ways to tile the given floor using 1 x m tiles. A tile can
 * either be placed horizontally or vertically. Both n and m are positive
 * integers and 2 < = m.
 * 
 * Examples:
 * 
 * Input : n = 2, m = 3 Output : 1 Only one combination to place two tiles of
 * size 1 x 3 horizontally on the floor of size 2 x 3.
 * 
 * Input : n = 4, m = 4 Output : 2 1st combination: All tiles are placed
 * horizontally 2nd combination: All tiles are placed vertically. Let “count(n)”
 * be the count of ways to place tiles on a “n x 4” grid, following two cases
 * arise when we place the first tile.
 * 
 * Place the first tile horizontally : If we place first tile horizontally, the
 * problem reduces to “count(n-1)” 
 * 
 * 
 * Place the first tile vertically : If we place
 * first tile vertically, then we must place m-1 more tiles vertically. So the
 * problem reduces to “count(n-m)”
 * 
 * @author mbansiwal
 *
 */
public class FloorTiles
{
	public static void countTiles(int n, int m)
	{
		int counts[] = new int[n + 1];
		counts[0] = 0;

		for (int i = 1; i < counts.length; i++)
		{
			if (i > m)
			{
				counts[i] = counts[i - 1] + counts[i - m];
			}
			else if (i < m)
			{
				counts[i] = 1;
			}
			else
			{
				counts[i] = 2;
			}
		}

		System.out.println(counts[n]);
	}

	public static void main(String[] args)
	{
		countTiles(7, 4);
		countTiles(5, 4);
	}
}

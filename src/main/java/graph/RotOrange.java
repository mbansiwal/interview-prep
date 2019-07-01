package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RotOrange
{
	public static class Pair
	{
		int x;
		int y;

		public Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args)
	{
		int arr[][] =
		{
				{
						2, 1, 0, 2, 1
				},
				{
						1, 0, 1, 2, 1
				},
				{
						1, 0, 0, 2, 1
				}
		};
		int ans = rotOranges2(arr);
		if (ans == -1)
		{
			System.out.println("All oranges cannot rot");
		} else
		{
			System.out.println("Time required for all oranges to rot = " + ans);
		}

		int arr2[][] =
		{
				{
						2, 1, 0, 2, 1
				},
				{
						0, 0, 1, 2, 1
				},
				{
						1, 0, 0, 2, 1
				}
		};
		ans = rotOranges2(arr2);
		if (ans == -1)
		{
			System.out.println("All oranges cannot rot");
		} else
		{
			System.out.println("Time required for all oranges to rot = " + ans);
		}
	}

	private static int rotOranges(int[][] arr)
	{
		Queue<Pair> pairs = new LinkedList<>();
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length; j++)
			{
				if (arr[i][j] == 2)
				{
					pairs.add(new Pair(i, j));
				}
			}
		}
		pairs.add(new Pair(-1, -1));
		int level = 0;
		while (!pairs.isEmpty())
		{
			Pair pair = pairs.poll();
			if (!isDelimiter(pair))
			{
				int x = pair.x;
				int y = pair.y;
				if (isValid(arr, x + 1, y))
				{
					arr[x + 1][y] = 2;
					pairs.add(new Pair(x + 1, y));
				}
				if (isValid(arr, x, y - 1))
				{
					arr[x][y - 1] = 2;
					pairs.add(new Pair(x, y - 1));
				}
				if (isValid(arr, x, y + 1))
				{
					arr[x][y + 1] = 2;
					pairs.add(new Pair(x, y + 1));
				}
				if (isValid(arr, x - 1, y))
				{
					arr[x - 1][y] = 2;
					pairs.add(new Pair(x - 1, y));
				}

				if (!pairs.isEmpty())
				{
					pairs.add(new Pair(-1, -1));
				}
			}

			if (!pairs.isEmpty())
			{
				if (isDelimiter(pair))
				{
					level++;
				}
			}
		}
		return level;
	}

	private static int rotOranges2(int[][] arr)
	{
		Queue<Pair> pairs = new LinkedList<>();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (arr[i][j] == 2)
				{
					pairs.add(new Pair(i, j));
				}
			}
		}
		int level = 0;
		while (!pairs.isEmpty())
		{
			boolean first = true;
			int size = pairs.size();
			for (int i = 0; i < size; i++)
			{
				Pair pair = pairs.poll();
				int x = pair.x;
				int y = pair.y;
				if (isValid(arr, x + 1, y))
				{
					arr[x + 1][y] = 2;
					pairs.add(new Pair(x + 1, y));
					if (first)
					{
						first = false;
						level++;
					}
				}
				if (isValid(arr, x, y - 1))
				{
					arr[x][y - 1] = 2;
					pairs.add(new Pair(x, y - 1));
					if (first)
					{
						first = false;
						level++;
					}
				}
				if (isValid(arr, x, y + 1))
				{
					arr[x][y + 1] = 2;
					pairs.add(new Pair(x, y + 1));
					if (first)
					{
						first = false;
						level++;
					}
				}
				if (isValid(arr, x - 1, y))
				{
					arr[x - 1][y] = 2;
					pairs.add(new Pair(x - 1, y));
					if (first)
					{
						first = false;
						level++;
					}
				}
			}
		}


		return isAllRotten(arr) ? level : -1;
	}

	private static boolean isValid(int[][] arr, int x, int y)
	{
		return x < 3 && x > -1 && y < 5 && y > -1 && arr[x][y] == 1;
	}

	private static boolean isDelimiter(Pair pair)
	{
		return pair.x == -1 && pair.y == -1;
	}

	private static boolean isAllRotten(int[][] arr)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (arr[i][j] == 1)
				{
					return false;
				}
			}
		}
		return true;
	}
}

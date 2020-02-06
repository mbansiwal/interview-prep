package arr;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix
{
	class RowColumPair
	{
		int row;
		int column;

		public RowColumPair(int row, int column)
		{
			this.row = row;
			this.column = column;
		}
	}

	public int kthSmallest(int[][] matrix, int k)
	{
		final int rows = matrix.length;
		final int columns = matrix[0].length;
		if ((rows * columns) < k)
		{
			return -1;
		}

		PriorityQueue<RowColumPair> queue = new PriorityQueue<>(k, (o1, o2) ->
				matrix[o1.row][o1.column] - matrix[o2.row][o2.column]);

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				queue.add(new RowColumPair(i, j));
				if (queue.size() > k)
				{
					queue.poll();
				}
			}
		}

		RowColumPair rowColumPair = queue.poll();
		for (int i = 1; i < k - 1; i++)
		{
			rowColumPair = queue.poll();
		}
		return matrix[rowColumPair.row][rowColumPair.column];
	}

	public int kthSmallest2(int[][] matrix, int k)
	{
		final int rows = matrix.length;
		final int columns = matrix[0].length;
		if ((rows * columns) < k)
		{
			return -1;
		}

		PriorityQueue<RowColumPair> queue = new PriorityQueue<>(k, new Comparator<RowColumPair>()
		{
			public int compare(RowColumPair o1, RowColumPair o2)
			{
				if (o1.row >= rows)
				{
					return 1;
				} else if (o2.row >= rows)
				{
					return -1;
				}
				return matrix[o1.row][o1.column] - matrix[o2.row][o2.column];
			};
		});
		for (int j = 0; j < columns; j++)
		{
			queue.add(new RowColumPair(0, j));
		}

		
		RowColumPair rowColumPair = null;
		for (int i = 0; i < k; i++)
		{
			rowColumPair = queue.poll();
			queue.add(new RowColumPair(rowColumPair.row + 1, rowColumPair.column));
		}
		return matrix[rowColumPair.row][rowColumPair.column];
	}

	public int kthSmallest3(int[][] matrix, int k)
	{
		final int rows = matrix.length;
		final int columns = matrix[0].length;
		if ((rows * columns) < k)
		{
			return -1;
		}

		PriorityQueue<RowColumPair> queue = new PriorityQueue<>(k, (o1, o2) -> matrix[o1.row][o1.column] - matrix[o2.row][o2.column]);
		queue.add(new RowColumPair(0, 0));

		RowColumPair rowColumPair = null;
		for (int i = 0; i < k; i++)
		{
			rowColumPair = queue.poll();
			if (rowColumPair.row == 0 && (rowColumPair.column + 1) < columns)
			{
				queue.add(new RowColumPair(rowColumPair.row, rowColumPair.column + 1));
			}

			if ((rowColumPair.row + 1) < rows)
			{
				queue.add(new RowColumPair(rowColumPair.row + 1, rowColumPair.column));
			}
		}
		return matrix[rowColumPair.row][rowColumPair.column];
	}

	public static void main(String[] args)
	{
		int k = 8;
		int matrix[][] =
		{
				{
						1, 5, 9
				},
				{
						10, 11, 13
				},
				{
						12, 14, 15
				}
		};
		System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest3(matrix, k));
	}
}

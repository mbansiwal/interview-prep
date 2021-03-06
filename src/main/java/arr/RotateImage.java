package arr;

public class RotateImage
{
	public void rotateClockWise(int[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int i = 0; i < rows; i++)
		{
			for (int j = i + 1; j < columns; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns / 2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][columns - 1 - j];
				matrix[i][columns - 1 - j] = temp;
			}
		}
	}

	public void rotateAntiClockWise(int[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns / 2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][columns - 1 - j];
				matrix[i][columns - 1 - j] = temp;
			}
		}

		for (int i = 0; i < rows; i++)
		{
			for (int j = i + 1; j < columns; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private void print(int[][] matrix){
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		RotateImage rotateImage = new RotateImage();
		int matrix[][] = 
				{
				  {1,2,3},
				  {4,5,6},
				  {7,8,9}
		};
		/***
		 * 7 8 9
		 * 4 5 6
		 * 1 2 3
		 * 
		 * 7 4 1
		 * 8 5 2
		 * 9 6 3
		 */
		rotateImage.rotateClockWise(matrix);
		rotateImage.print(matrix);

		System.out.println();
		int matrix2[][] =
		{
				{
						1, 2, 3, 11
				},
				{
						4, 5, 6, 12
				},
				{
						7, 8, 9, 13
				},
				{
						14, 15, 16, 17
				}
		};
		rotateImage.rotateAntiClockWise(matrix2);

		rotateImage.print(matrix2);
		
		int matrix3[][] = {
				{5,  1,  9,  11},
				{2,  4,  8,  10},
				{13, 3,  6,  7},
				{15, 14, 12, 16}
		};

		/**
		 * 15 14 12 16 2 4 8 10 13 3 6 7 5 1 9 11
		 * 
		 * 15 2 14
		 */
		rotateImage.rotateClockWise(matrix3);
		rotateImage.print(matrix3);
	}
}

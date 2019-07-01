package dp.matrix;

public class MatrixMultiplicationMinimumCost {
	public static void main(String[] args) 
	{
		int arr[] = {4,2,3,5,3};
        int cost = findMinimumCost(arr);
		System.out.println(cost);

		System.out.println(matrixChainOrder(arr, arr.length));

		int arr2[] = new int[]
		{
				1, 2, 3, 4
		};
		System.out.println(matrixChainOrder(arr2, arr2.length));
	}

	static int findMinimumCost(int arr[])
	{
		int n = arr.length;
        int temp[][] = new int[n][n];
        int q = 0;
        for(int l=2; l < n; l++)
        {
            for(int i=0; i < n - l; i++)
            {
                int j = i + l;
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++)
                {
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j])
                    {
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length-1];
	}

	static int matrixChainOrder(int arr[], int n)
	{
		int table[][] = new int[n][n];
		for (int l = 2; l <= n; l++)
		{
			for (int i = 1; i < n - l + 1; i++)
			{
				int j = i + l - 1;
				if (j == n)
				{
					continue;
				}
				table[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++)
				{
					table[i][j] = Math.min(table[i][j], table[i][k] + table[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);
				}
			}
		}

		return table[1][n - 1];
	}
}

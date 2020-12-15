package dp.matrix;

import java.util.Arrays;

public class FindMaxPathInMatrix 
{
	int[] dfx = {-1,1,0,0};
	int[] dfy = {0,0,-1,1};
	
	private boolean isValid(int i, int j, int n)
	{
		return i >= 0 && j >= 0 && i < n && j <n;
	}
	
	private boolean isVisited(int dp)
	{
		return dp > -1;
	}
	
	private int dfs(int[][]matrix, int[][] dp, int i, int j)
	{
		int n = matrix[0].length;
		if(!isValid(i, j, n))
		{
			return 0;
		}
		
		if(isVisited(dp[i][j]))
		{
			return dp[i][j];
		}
		
		for (int x = 0; x < dfx.length; x++) 
		{
			int c1x = i + dfx[x];
			int c1y = j + dfy[x];
			
			if(isValid(c1x, c1y, n) && (matrix[c1x][c1y]-matrix[i][j]) == 1)
			{
				dp[i][j] = 1 + dfs(matrix, dp, c1x, c1y);
			}
		}
		return dp[i][j]==-1?1:dp[i][j];
	}
	
	public int findLongestPath(int[][] matrix)
	{
		int n = matrix[0].length;
		int[][] dp = new int[n][n];
		int result = 0;
		
		for (int i = 0; i < dp.length; i++) 
		{
			Arrays.fill(dp[i], -1);
		}
		
		for (int i = 0; i < dp.length; i++) 
		{
			for (int j = 0; j < dp.length; j++) 
			{
				if(!isVisited(dp[i][j]))
				{
					result = Math.max(result, dfs(matrix, dp, i, j));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		int  matrix[][] = {
				{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};
		FindMaxPathInMatrix findMaxPathInMatrix = new FindMaxPathInMatrix();
		System.out.println(findMaxPathInMatrix.findLongestPath(matrix));
	}
}

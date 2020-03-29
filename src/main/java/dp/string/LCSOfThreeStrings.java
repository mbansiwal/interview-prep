package dp.string;

public class LCSOfThreeStrings {
	public static void main(String args[]) {
		String X = "AGGT12";
	    String Y = "12TXAYB";
	    String Z = "12XBA";
		mySolution(X.toCharArray(), Y.toCharArray(), Z.toCharArray());
		findLcs(X.toCharArray(), Y.toCharArray(), Z.toCharArray());
	}
	
	private static void mySolution(char[] arr1, char[] arr2, char[] arr3)
	{
		int[][][] ls = new int[arr1.length+1][arr2.length+1][arr3.length+1];
		for (int i = 1; i <= arr1.length; i++) 
		{
			char c1 = arr1[i-1];
			for (int j = 1; j <= arr2.length; j++) 
			{
				char c2 = arr2[j-1];
				for (int k = 1; k <= arr3.length; k++) 
				{
					char c3 = arr3[k-1];
					if(c1 == c2 && c1 == c3)
					{
						ls[i][j][k] = ls[i-1][j-1][k-1]+1;
					}
					else
					{
						ls[i][j][k] =
								Math.max(ls[i-1][j][k], Math.max(ls[i][j-1][k], ls[i][j][k-1]));
					}
				}
			}
		}
		
		System.out.println(ls[arr1.length][arr2.length][arr3.length]);
	}
	
	private static void findLcs(char[] arr1, char[] arr2, char[] arr3)
	{
		int[] ls = new int[arr3.length+1];
		
		for (int i = 1; i <= arr1.length; i++) 
		{
			char c1 = arr1[i-1];
			for (int j = 1; j <= arr2.length; j++) 
			{
				char c2 = arr2[j-1];
				for (int k = 1; k <= arr3.length; k++) 
				{
					char c3 = arr3[k-1];
					if(c1 == c2 && c1 == c3)
					{
						ls[k] = ls[k-1]+1;
					}
					else
					{
						ls[k] = Math.max(ls[k-1], ls[k]);
					}
				}
			}
		}
		System.out.println(ls[arr3.length]);
	}
}

package dp;

import java.util.Arrays;

//A Dynamic Programming solution for Rod cutting problem
class RodCutting
{
 /* Returns the best obtainable price for a rod of
    length n and price[] as prices of different pieces */
 static int cutRod(int price[],int n)
 {
     int val[] = new int[n+1];
     val[0] = 0;

     // Build the table val[] in bottom up manner and return
     // the last entry from the table
     for (int i = 1; i<=n; i++)
     {
         int max_val = Integer.MIN_VALUE;
         for (int j = 0; j < i; j++)
         {  
        	 max_val = Math.max(max_val, 
                               price[j] + val[i-j-1]);
         }
         val[i] = max_val;
     }

     return val[n];
 }

 /* Driver program to test above functions */
 public static void main(String args[])
 {
     int arr[] = new int[] {2,	5,	7,	8, 5};
     int size = arr.length;
     System.out.println("Maximum Obtainable Value is " +
                         cutRod(arr, size));
     System.out.println("Maximum Obtainable Value is " +
             cutRod2(arr, size));
     
     cutRodOptimalSolution(arr, size);
     
     int arr2[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
     System.out.println("Maximum Obtainable Value is " +
             cutRod2(arr2, arr2.length));
     cutRodOptimalSolution(arr2, arr2.length);
     int markings[] = {2,3,6,7};
     
     System.out.println("Minimum Cost");
     cutRodOptimalSolutionMinimizeCost(markings, 8);
 }
 
 
 static void cutRodOptimalSolution(int rodPieceValues[], int rodLength)
 {
	 int[] table = new int[rodLength+1];
	 for (int i = 1; i <= rodPieceValues.length; i++) 
	 {
		 int rodPiecePrice = rodPieceValues[i-1];
		 for (int j = i; j <= rodLength; j++) 
		 {
			if(j >= i)
			{
				table[j] = Math.max(table[j], table[j - i]+rodPiecePrice);
			}
		 }
		 System.out.println(Arrays.toString(table));
	 }
	 System.out.println(Arrays.toString(table));
	 System.out.println("Optimal Solution: "+table[rodLength]);
 }
 
 static void cutRodOptimalSolutionMinimizeCost(int rodPieceValues[], int rodLength)
 {
	 int[] table = new int[rodLength+1];
	 Arrays.fill(table, Integer.MAX_VALUE);
	 table[0] = 0;
	 for (int i = 1; i <= rodPieceValues.length; i++) 
	 {
		 int rodPiecePrice = rodPieceValues[i-1];
		 for (int j = i; j <= rodLength; j++) 
		 {
				table[j] = Math.min(table[j], table[j - i]+rodPiecePrice);
		 }
		 System.out.println(Arrays.toString(table));
	 }
	 System.out.println(Arrays.toString(table));
	 System.out.println("Optimal Solution: "+table[rodLength]);
 }
 
 static int cutRod2(int price[],int n)
 {
	 int m = price.length;
	 int[][] T = new int[m+1][n+1];
	 for(int i=1;i<=m;++i)
	 {
	 	int rodValue = price[i-1];

	 	for(int j=1;j<=n;++j)
	 	{
	 		if(j < i)
	 		{
	 			T[i][j] = T[i-1][j];
	 		}
	 		else
	 		{
	 			T[i][j] = Math.max(T[i-1][j], T[i][j-i]+rodValue);
	 		}
	 	}
	 }
	 for (int[] vals : T) {
			for (int i : vals) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	 return T[m][n];
 }
}

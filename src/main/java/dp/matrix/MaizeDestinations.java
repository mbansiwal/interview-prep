package dp.matrix;

import java.util.Arrays;

public class MaizeDestinations {
	public static void destinations(int[][] maize)
	{
		for (int j = 0; j < maize.length; j++) 
		{
			if(maize[0][j] == 0)
			{
				maize[0][j] = 1;
			}
			else
			{
				break;
			}
		}
		
		for (int i = 0; i < maize.length; i++) 
		{
			if(maize[i][0] == 0)
			{
				maize[i][0] = 1;
			}
			else
			{
				break;
			}
		}
		
		System.out.println(Arrays.toString(maize[0]));
		for (int i = 1; i < maize.length; i++) 
		{
			for (int j = 1; j < maize.length; j++) 
			{
				if(maize[i-1][j] > 0)
				{
					maize[i][j] = maize[i][j] + maize[i-1][j];
				}
				
				if(maize[i][j-1] > 0)
				{
					maize[i][j] = maize[i][j] + maize[i][j-1];
				}
			}
			System.out.println(Arrays.toString(maize[i]));
		}
		
		System.out.println(maize[maize.length-1][maize.length-1]);
	}
	
	public static void main(String[] args) {
		int maize[][] =
		{
				{
						0, 0, 0, 0
				},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0,  0, 0, 0}};
		
		destinations(maize);
	}
}

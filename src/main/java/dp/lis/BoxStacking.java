package dp.lis;

import java.util.Arrays;

class Box implements Comparable<Box>
{
	int h, w, d;
	
	public Box(int h, int w, int d)
	{
		super();
		this.h = h;
		this.w = w;
		this.d = d;
	}

	@Override
	public int compareTo(Box o)
	{
		return ( o.d * o.w ) - d*w;
	}
}
public class BoxStacking
{
	static int maxStackHeight( Box arr[], int n )
	{
	   /* Create an array of all rotations of given boxes
	      For example, for a box {1, 2, 3}, we consider three
	      instances{{1, 2, 3}, {2, 1, 3}, {3, 1, 2}} */
	   Box rot[] = new Box[3*n];
	   int index = 0;
	   for (int i = 0; i < n; i++)
	   {
	      // Copy the original box
	      rot[index] = arr[i];
	      index++;
	 
	      // First rotation of box
	      int h = arr[i].w;
	      int d = Math.max(arr[i].h, arr[i].d);
	      int w = Math.min(arr[i].h, arr[i].d);
	      rot[index] = new Box(h, w, d);
	      index++;
	 
	      // Second rotation of box
	      h = arr[i].d;
	      d = Math.max(arr[i].h, arr[i].w);
	      w = Math.min(arr[i].h, arr[i].w);
	      rot[index] = new Box(h, w, d);
	      index++;
	   }
	 
	   // Now the number of boxes is 3n
	   n = 3*n;
	 
	   /* Sort the array 'rot[]' in decreasing order, using library
	      function for quick sort */
	   Arrays.sort(rot);
	 
	   // Uncomment following two lines to print all rotations
	   // for (int i = 0; i < n; i++ )
	   //    printf("%d x %d x %d\n", rot[i].h, rot[i].w, rot[i].d);
	 
	   /* Initialize msh values for all indexes 
	      msh[i] --> Maximum possible Stack Height with box i on top */
	   int msh[] = new int[n];
	   for (int i = 0; i < n; i++ )
	   {
		   msh[i] = rot[i].h;
	   }
	 
	   /* Compute optimized msh values in bottom up manner */
	   for (int i = 1; i < n; i++ )
	   {
		   for (int j = 0; j < i; j++ )
		   {
			   if ( rot[i].w < rot[j].w &&
	              rot[i].d < rot[j].d &&
	              msh[i] < msh[j] + rot[i].h
	            )
	         {
	              msh[i] = msh[j] + rot[i].h;
	         }
		   }
	   }
	 
	   /* Pick maximum of all msh values */
	   int max = -1;
	   for ( int i = 0; i < n; i++ )
	   {
		   if ( max < msh[i] )
		   {
			   max = msh[i];
		   }
	   }
	   return max;
	}
	
	public static void main(String[] args)
	{
		Box arr[] = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32) };
		System.out.println(maxStackHeight (arr, arr.length));
	}
}

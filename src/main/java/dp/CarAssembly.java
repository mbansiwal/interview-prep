package dp;

public class CarAssembly {
	static int carAssembly(int assemblyTime[][], int assemblyChangeTime[][], int entryTime[], int exitTime[])
	{
		int noOfAssemblies = assemblyTime[0].length;
	    int T1[] = new int[noOfAssemblies];
	    int T2[] = new int[noOfAssemblies];
	 
	    T1[0] = entryTime[0] + assemblyTime[0][0]; // time taken to leave first station in line 1
	    T2[0] = entryTime[1] + assemblyTime[1][0]; // time taken to leave first station in line 2
	 
	    // Fill tables T1[] and T2[] using the above given recursive relations
	    for (int i = 1; i < noOfAssemblies; ++i)
	    {
	        T1[i] = Math.min(T1[i-1] + assemblyTime[0][i], T2[i-1] + assemblyChangeTime[1][i] + assemblyTime[0][i]);
	        T2[i] = Math.min(T2[i-1] + assemblyTime[1][i], T1[i-1] + assemblyChangeTime[0][i] + assemblyTime[1][i]);
	    }
	 
	    // Consider exit times and retutn minimum
	    return Math.min(T1[noOfAssemblies-1] + exitTime[0], T2[noOfAssemblies-1] + exitTime[1]);
	}
	 
	public static void main(String[] args) 
	{
	    int assemblyTime[][] = {
	    				{4, 5, 3, 2},
	    				{2, 10, 1, 4}
	    			};
	    
	    int assemblyChangeTime[][] = {
	    				{0, 7, 4, 5},
	    				{0, 9, 2, 8}
	    			};
	    
	    int entryTime[] = {10, 12};
	    int exitTime[] = {18, 7};
	 
	    System.out.println(carAssembly(assemblyTime, assemblyChangeTime, entryTime, exitTime));
	    System.out.println(carAssembly2(assemblyTime, assemblyChangeTime, entryTime, exitTime));
	}
	
	static int carAssembly2(int assemblyTime[][], int assemblyChangeTime[][], int entryTime[], int exitTime[])
	{
		int noOfAssemblies = assemblyChangeTime[0].length;
		int T1[] = new int[noOfAssemblies];
		int T2[] = new int[noOfAssemblies];
		
		T1[0] = assemblyTime[0][0]+entryTime[0];
		T2[0] = assemblyTime[1][0]+entryTime[1];
		
		for (int i = 1; i < noOfAssemblies; i++) 
		{
			T1[i] = assemblyTime[0][i] + Math.min(T1[i-1], T2[i-1]+assemblyChangeTime[1][i]);
			T2[i] = assemblyTime[1][i] + Math.min(T2[i-1], T1[i-1]+assemblyChangeTime[0][i]);
		}
		
		return Math.min(T1[noOfAssemblies-1] + exitTime[0], T2[noOfAssemblies-1]+exitTime[1]);
	}
}

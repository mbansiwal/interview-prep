package arr;
class KadaneResult{
    int maxSum;
    int start;
    int end;
    public KadaneResult(int maxSum, int start, int end) {
        this.maxSum = maxSum;
        this.start = start;
        this.end = end;
    }
    
    public String toString() {
    	return "sum="+maxSum+", start="+start+",end="+end;
    }
}
public class KadanesAlgo 
{
	public KadaneResult findMax(int[] arr)
	{
		int maxSum = arr[0];
		int start = 0;
		int end = 0;
		int currentStartIndex=0;
		
		int n = arr.length;
		int currentSum = maxSum;
		for (int i = 1; i < n; i++) 
		{
			currentSum += arr[i];
			if(currentSum < arr[i])
			{
				currentSum = arr[i];
				currentStartIndex = i;
			}
			else if(currentSum > maxSum)
			{
				maxSum = currentSum;
				end = i;
				start = currentStartIndex;
			}
		}
		return new KadaneResult(maxSum, start, end);
	}
	
	public static void main(String[] args) {
		KadanesAlgo algo = new KadanesAlgo();
		int[] arr = {-2,3,1,-1};
		System.out.println(algo.findMax(arr));
		
		int[] arr2 = {1,6,-2,3};
		System.out.println(algo.findMax(arr2));
		
		int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(algo.findMax(a));

		int arr3[] =
		{
				1, 12, -5, -6, 50, 3
		};
		System.out.println(algo.findMax(arr3));
	}
}

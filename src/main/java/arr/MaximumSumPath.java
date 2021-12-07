package arr;

public class MaximumSumPath {
	int maxPathSum(int arr1[], int arr2[])  
    { 
		int m = arr1.length;
		int n = arr2.length;
		
		int sum1 = 0;
		int sum2 = 0;
		
		int result = 0;
		int i = 0;
		int j = 0;
		while(i < m && j < n) {
			if(arr1[i] < arr2[j]) {
				sum1 += arr1[i++];
			} else if(arr1[i] > arr2[j]) {
				sum2 += arr2[j++];
			} else {
				result += Math.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
				
				while(i < m && j < n && arr1[i] == arr2[j]) {
					result+=arr1[i++];
					j++;
				}
			}
		}
		
		while(i < m) {
			sum1 += arr1[i++];
		}
		
		while(j < n) {
			sum2 += arr2[j++];
		}
		
		result += Math.max(sum1, sum2);
		return result;
    }
	
	int maxPathSum2(int arr1[], int arr2[])  
    {
		int sum1 = 0;
		int sum2 = 0;
		int result = 0;
		int n1 = arr1.length;
		int n2 = arr2.length;
		int i = 0;
		int j = 0;
		while(i < n1 && j < n2) {
			if(arr1[i] < arr2[j]) {
				sum1+= arr1[i++];
			} else if(arr1[i] > arr2[j]) {
				sum2+= arr2[j++];
			} else {
				result += Math.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
				while(i < n1 && j < n2 && arr1[i] == arr2[j]) {
					result+= arr1[i];
					i++;
					j++;
				}
			}
		}
		
		while(i < n1) {
			sum1+= arr1[i++];
		}
		
		while(j < n2) {
			sum2+= arr2[j++];
		}
		result += Math.max(sum1, sum2);
		return result; 
    }
	
	public static void main(String[] args)  
    { 
        MaximumSumPath sumpath = new MaximumSumPath(); 
        int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}; 
        int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19}; 
        System.out.println("Maximum sum path is :" +  
                                       sumpath.maxPathSum(ar1, ar2)); 
        System.out.println("Maximum sum path is :" +  
                sumpath.maxPathSum2(ar1, ar2)); 
    } 
}

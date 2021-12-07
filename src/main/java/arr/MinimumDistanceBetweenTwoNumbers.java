package arr;

public class MinimumDistanceBetweenTwoNumbers {
	public int minDist(int arr[], int n, int x, int y)  
    { 
		int result = Integer.MAX_VALUE;
		
		int prevIndex = -1;
		
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == x || arr[i] == y) {
				if(prevIndex != -1 && arr[i] != arr[prevIndex]) {
					result = Math.min(result, i - prevIndex);
				}
				prevIndex = i;
			}
		}
		
		return result;
    }
	
	public int minDist2(int arr[], int n, int x, int y)  
    {
		int prevIndex = -1;
		
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == x || arr[i] == y) {
				if(prevIndex != -1 && arr[i]!= arr[prevIndex]) {
					dist = Math.min(dist, i-prevIndex);
				}
				prevIndex = i;
			}
		}
		return dist;
    }
	
	public static void main(String[] args) {
		MinimumDistanceBetweenTwoNumbers min = new MinimumDistanceBetweenTwoNumbers(); 
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3}; 
        int n = arr.length; 
        int x = 3; 
        int y = 6; 
  
        System.out.println("Minimum distance between " + x + " and " + y 
                + " is " + min.minDist(arr, n, x, y)); 
        System.out.println("Minimum distance between " + x + " and " + y 
                + " is " + min.minDist2(arr, n, x, y));
	}
}

package arr;

public class RepeatingAndMissingNumber {
	static void printTwoElements(int arr[]) 
    { 
		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i])-1;
			if(arr[index] < 0) {
				System.out.println("Duplicate Number: "+Math.abs(arr[index]));
			} else {
				arr[index] = -arr[index];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				System.out.println("Missing Number: "+ (i+1));
			}
		}
    }
	public static void main(String[] args) {
		int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
		printTwoElements(arr);
	}
}

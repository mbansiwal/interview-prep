package arr;

public class SquareRoot {
	static float findSquareRoot(float input){
		float x = input;
		float y = 1;
		float e = 0.000001f;
		while( x - y > e) {
			x = (x+y)/2;
			y = input/x;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		int n = 50; 
		  
        System.out.println("Square root of "
                          + n + " is " + findSquareRoot(n));
        
        System.out.println("Square root of "
                + n + " is " + findSquareRoot(100));
	}
}

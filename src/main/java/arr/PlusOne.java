package arr;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int n = digits.length;                                   
        return plusOneUtil(digits, n-1);                           
    }
    
    
    private int[] plusOneUtil(int[] digits, int index){
        int digit = digits[index];
        digit++;
        if(digit == 10){
            digits[index] = 0;
            if(index == 0) {
            	int[] output = new int[digits.length+1];
            	for (int i = 0; i < digits.length; i++) {
					output[i+1] = digits[i];
				}
                output[0] = 1;
                digits = output;
            }
            if(index > 0)
            {
            	digits = plusOneUtil(digits, index-1);
            }
        } else{
            digits[index] = digit;
        }
        return digits;
    }
    
    public static void main(String[] args) {
    	int[] digits = {9,9};
    	int[] output = new PlusOne().plusOne(digits);
    	
		System.out.println(Arrays.toString(output));
	}
}

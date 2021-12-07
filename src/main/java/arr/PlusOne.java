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
    
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        int[] result = new int[n+1];
        int carry = 1;
        for(int i=n-1; i >=0; --i){
            int temp = digits[i]+carry;
            if(temp == 10){
                carry = 1;                             
            } else{
                carry = 0;
                result[i+1] = temp;
            }
        }
        if(carry != 0){
            result[0] = carry;
            digits = result;
        } else{
            for(int i=0; i < n; ++i){
                digits[i] = result[i+1];
            }
        }
        
        
        return digits;
    }
    
    public int[] plusOne3(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for(int i=n-1; i >=0; --i){
            int temp = digits[i]+carry;
            if(temp == 10){
                carry = 1;  
                digits[i] = 0;
            } else{
                carry = 0;
                digits[i] = temp;
            }
        }
        if(carry != 0){
        	int[] result = new int[n+1];
        	for (int i = 1; i < result.length; i++) {
				result[i] = digits[i-1];
			}
            result[0] = carry;
            digits = result;
        } 
        return digits;
    }
    
    public static void main(String[] args) {
    	int[] digits = {9,9};
    	int[] output = new PlusOne().plusOne(digits);
    	
		System.out.println(Arrays.toString(output));
		
		int[] digits2 = {9,9};
		System.out.println(Arrays.toString(new PlusOne().plusOne2(digits2)));
		int[] digits3 = {9,9};
		System.out.println(Arrays.toString(new PlusOne().plusOne3(digits3)));
	}
}

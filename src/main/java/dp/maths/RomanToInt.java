package dp.maths;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	public int romanToInt(String s) {
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        hmap.put('I',1);
        hmap.put('V',5);
        hmap.put('X',10);
        hmap.put('L',50);
        hmap.put('C',100);
        hmap.put('D',500);
        hmap.put('M',1000); 
        
		char[] str = s.toCharArray();
		
		int n = str.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int currentInt = hmap.get(str[i]);
			int nextInt = 0;
			if(i < n - 1) {
				nextInt = hmap.get(str[i+1]);
			}
			
			if(nextInt > currentInt) {
				i++;
				sum += nextInt - currentInt;
			} else {
				sum += currentInt;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
		System.out.println(new RomanToInt().romanToInt("LVIII"));
		System.out.println(new RomanToInt().romanToInt("III"));
		System.out.println(new RomanToInt().romanToInt("IV"));
		System.out.println(new RomanToInt().romanToInt("IX"));
	}
}

package arr;

public class ExcelToNumber {
	public int titleToNumber(String s) {
        char[] arr = s.toCharArray();
        int column = 0;
        int n = arr.length;
        for(int i=0; i < n; ++i){
            int newValue = arr[i] - 65 + 1;
            column = column*26 + newValue;
        }
        
        return column;
    }
	
	public static void main(String[] args) {
		System.out.println(new ExcelToNumber().titleToNumber("B"));
	}
}

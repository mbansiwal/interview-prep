package arr;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] table = new int[matrix[0].length];
        MaximumHistogram hist = new MaximumHistogram();
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == '0') {
					table[j] = 0;
				} else {
					table[j] = table[j] + 1;
				}
			}
			maxArea = Math.max(maxArea, hist.maxHistogram(table));
		}
        return maxArea;
    }
	
	public static void main(String[] args) {
		char[][]matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}
}

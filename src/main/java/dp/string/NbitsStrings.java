package dp.string;

import java.util.Arrays;

public class NbitsStrings {

	public void nBits(int n, int[] arrA) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arrA));
		} else {
			arrA[n - 1] = 0;
			nBits(n - 1, arrA);
			arrA[n - 1] = 1;
			nBits(n - 1, arrA);
		}
	}

	public void nBits(int n) {
		int[] arrA = new int[n];
		nBits(n, arrA);
	}

	public static void main(String[] args) throws java.lang.Exception {
		int n = 3;
		NbitsStrings i = new NbitsStrings();
		i.nBits(n);
	}

}

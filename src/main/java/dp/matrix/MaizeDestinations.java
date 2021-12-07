package dp.matrix;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
 * 
 * Given a maze with obstacles, count the number of paths to reach the
 * rightmost-bottommost cell from the topmost-leftmost cell. A cell in the given
 * maze has a value of -1 if it is a blockage or dead-end, else 0. From a given
 * cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.
 * 
 * @author Administrator
 *
 */
public class MaizeDestinations {
	public static void destinations(int[][] maize) {
		for (int j = 0; j < maize.length; j++) {
			if (maize[0][j] == 0) {
				maize[0][j] = 1;
			} else {
				break;
			}
		}

		for (int i = 0; i < maize.length; i++) {
			if (maize[i][0] == 0) {
				maize[i][0] = 1;
			} else {
				break;
			}
		}

		System.out.println(Arrays.toString(maize[0]));
		for (int i = 1; i < maize.length; i++) {
			for (int j = 1; j < maize.length; j++) {
				if (maize[i - 1][j] > 0) {
					maize[i][j] = maize[i][j] + maize[i - 1][j];
				}

				if (maize[i][j - 1] > 0) {
					maize[i][j] = maize[i][j] + maize[i][j - 1];
				}
			}
			System.out.println(Arrays.toString(maize[i]));
		}

		System.out.println(maize[maize.length - 1][maize.length - 1]);
	}

	public static void main(String[] args) {
		int maize[][] = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };

		destinations(maize);
	}
}

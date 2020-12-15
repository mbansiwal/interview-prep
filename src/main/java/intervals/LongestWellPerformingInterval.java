package intervals;

import java.util.HashMap;
import java.util.Map;

class LongestWellPerformingIntervalResult {

}

public class LongestWellPerformingInterval {
	public int longestWPI(int[] arr) {
		int result = 0;
		int diff = 0;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			diff += (arr[i] > 8 ? 1 : -1);
			if (diff > 0) {
				result = i+1;

			} else if (map.containsKey(diff-1)) {
				result = Math.max(result, i - map.get(diff-1));
			} else {
				map.putIfAbsent(diff, i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] hours = { 9, 9, 6, 0, 6, 6, 9 };
		System.out.println(new LongestWellPerformingInterval().longestWPI(hours));

		int[] hours2 = { 8, 12, 7, 6, 10, 10, 9, 11, 12, 6 };
		System.out.println(new LongestWellPerformingInterval().longestWPI(hours2));
	}
}

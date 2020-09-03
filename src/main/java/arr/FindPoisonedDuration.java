package arr;

/**
 * https://leetcode.com/problems/teemo-attacking/
 * 
 * @author mbbansiw
 *
 */
public class FindPoisonedDuration {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int n = timeSeries.length;
		
		if(n == 0) {
			return 0;
		}
		
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			count += Math.min(timeSeries[i+1] - timeSeries[i], duration);
		}
		
        return count + duration;
    }
	
	public static void main(String[] args) {
		int[] timeSeries = {2, 4};
		System.out.println(new FindPoisonedDuration().findPoisonedDuration(timeSeries, 2));
		
		int[] timeSeries2 = {1, 2};
		System.out.println(new FindPoisonedDuration().findPoisonedDuration(timeSeries2, 2));
	}
}

package dp.lis;

/**
 * https://www.geeksforgeeks.org/minimum-time-to-finish-tasks-without-skipping-two-consecutive
 * 
 * Given time taken by n tasks. Find the minimum time needed to finish the tasks
 * such that skipping of tasks is allowed, but can not skip two consecutive
 * tasks.
 * 
 * 
 * Examples :
 * 
 * Input : arr[] = {10, 5, 7, 10} Output : 12 We can skip first and last task
 * and finish these task in 12 min.
 * 
 * Input : arr[] = {10} Output : 0 There is only one task and we can skip it.
 * 
 * Input : arr[] = {10, 30} Output : 10
 * 
 * Input : arr[] = {10, 5, 2, 4, 8, 6, 7, 10} Output : 22
 * 
 * @author mbbansiw
 *
 */
public class MinimumTimeToFinishTasksWithoutSkippingTwoConsecutive {
	public static void minimumSum(int[] arr) {
		int excl = 0;
		int incl = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int temp = incl;
			incl = arr[i] + Math.min(incl, excl);
			excl = temp;
		}
		System.out.println(Math.min(incl, excl));
	}

	public static void min(int[] arr) {
		int incl = arr[0];
		int excl = 0;

		for (int i = 1; i < arr.length; i++) {
			int newIncl = arr[i] + Math.min(excl, incl);

			excl = incl;
			incl = newIncl;
		}

		System.out.println(Math.min(incl, excl));
	}

	public static void main(String[] args) {
		int arr1[] = { 10, 5, 7, 10 };
		min(arr1);
		minimumSum(arr1);
	}
}

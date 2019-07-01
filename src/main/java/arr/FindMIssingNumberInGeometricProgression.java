package arr;

public class FindMIssingNumberInGeometricProgression {

	public static void main(String[] args) {
		int arr[] = {2, 4, 8, 32};
	    System.out.println(findMissing(arr, arr.length));
	}

	static int findMissingRec(int arr[], int low, int high, int ratio) {
		if (low >= high)
			return Integer.MAX_VALUE;
		int mid = low + (high - low) / 2;

		// If element next to mid is missing
		if (arr[mid + 1] / arr[mid] != ratio)
		{
			return (arr[mid] * ratio);
		}

		// If elem]-o'pl/';ent previous to mid is missing
		if ((mid > 0) && (arr[mid] / arr[mid - 1]) != ratio)
		{
			return (arr[mid - 1] * ratio);
		}

		// If missing element is in right half
		if (arr[mid] == arr[0] * (Math.pow(ratio, mid)))
		{
			return findMissingRec(arr, mid + 1, high, ratio);
		}

		return findMissingRec(arr, low, mid - 1, ratio);
	}

	// Find ration and calls findMissingRec
	static int findMissing(int arr[], int n) {
		// Finding ration assuming that the missing term is
		// not first or last term of series.
		int ratio = (int) Math.pow(arr[n - 1] / arr[0], 1.0 / n);
		System.out.println(ratio);
		return findMissingRec(arr, 0, n - 1, ratio);
	}
}


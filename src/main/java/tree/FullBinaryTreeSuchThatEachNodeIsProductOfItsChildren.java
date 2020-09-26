package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/number-full-binary-trees-node-product-children/
 *
 * Given an array of n integers, each integer is greater than 1. The task is to
 * find the number of Full binary tree from the given integers, such that each
 * non-node leaf node value is the product of its children value. Given that,
 * each integer can be used multiple times in a full binary tree. Examples:
 *
 * Input : arr[] = { 2, 3, 4, 6 }. Output : 7 There can be 7 full binary tree
 * with the given product property.
 *
 * // Four trees with single nodes 2 3 4 6
 *
 * // Three trees with three nodes 4 , / \ 2 2
 *
 * 6 , / \ 2 3
 *
 * 6 / \ 3 2 Recommended: Please solve it on “PRACTICE” first, before moving on
 * to the solution. We find maximum value in given array and create an array to
 * store presence of elements in this array. The idea is, for all multiples of
 * each integer less than the maximum value of the array, try to make full
 * binary tree if the multiple is present in the array. Observe that for any
 * full binary tree with given property, the smaller values will always be at
 * the last level. So, try to find the number of such full binary tree from the
 * minimum value of the array to maximum value of the array.
 *
 *
 *
 *
 * Algorithm to solve the problem: 1. Initialize possible number of such full
 * binary tree for each element equal to 1. Since single node also contribute to
 * the answer. 2. For each element of the array, arr[i], from minimum value to
 * maximum value of array. ……a) For each multiple of arr[i], find if multiple is
 * present or not. ……b) If yes, then the number of such possible full binary
 * tree for multiple of arr[i], say m, is equal to the product of the number of
 * such possible full binary tree of arr[i] and number of such possible full
 * binary tree of arr[i]/m.
 */
public class FullBinaryTreeSuchThatEachNodeIsProductOfItsChildren {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 6 };
		int n = arr.length;

		System.out.print(numoffbt(arr, n));
	}

	private static int numoffbt(int[] arr, int n) {
		int ans = 0;
		Map<Integer, Integer> valueMap = new HashMap<>();
		Set<Integer> arrSet = Arrays.stream(arr).boxed().collect(Collectors.toSet());
		for (Integer element : arr) {
			valueMap.put(element, 1);
		}

		int minValue = Arrays.stream(arr).min().getAsInt();
		int maxValue = Arrays.stream(arr).max().getAsInt();
		for (int i = minValue; i <= maxValue; ++i) {
			if (arrSet.contains(i)) {
				for (int j = i + i; j <= maxValue && j / i <= i; j += i) {
					if (arrSet.contains(j)) {
						valueMap.put(j, valueMap.get(j) + valueMap.getOrDefault(i, 0) * valueMap.getOrDefault(j / i, 0));
						if (i != j / i) {
							valueMap.put(j,
									valueMap.get(j) + valueMap.getOrDefault(i, 0) * valueMap.getOrDefault(j / i, 0));
						}
					}
				}
			}
			ans += valueMap.getOrDefault(i, 0);
		}
		return ans;
	}
}

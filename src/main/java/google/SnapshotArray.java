package google;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/snapshot-array/ Implement a SnapshotArray that
 * supports the following interface:
 * 
 * SnapshotArray(int length) initializes an array-like data structure with the
 * given length. Initially, each element equals 0. void set(index, val) sets the
 * element at the given index to be equal to val. int snap() takes a snapshot of
 * the array and returns the snap_id: the total number of times we called snap()
 * minus 1. int get(index, snap_id) returns the value at the given index, at the
 * time we took the snapshot with the given snap_id
 * 
 * 
 * Example 1:
 * 
 * Input: ["SnapshotArray","set","snap","set","get"] [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5] Explanation: SnapshotArray snapshotArr = new
 * SnapshotArray(3); // set the length to be 3 snapshotArr.set(0,5); // Set
 * array[0] = 5 snapshotArr.snap(); // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6); snapshotArr.get(0,0); // Get the value of array[0] with
 * snap_id = 0, return 5
 * 
 * @author Administrator
 *
 */
public class SnapshotArray {
	private List<int[]> arr[];
	private int snap;

	public SnapshotArray(int length) {
		arr = new List[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
			arr[i].add(new int[] { -1, 0 });
		}
	}

	public void set(int index, int val) {
		arr[index].add(new int[] { snap, val });
	}

	public int snap() {
		return snap++;
	}

	public int get(int index, int snapId) {
		int low = 0;
		List<int[]> elements = arr[index];
		int high = elements.size() - 1;

		while (low < high) {
			int mid = high - (high - low) / 2;

			if (elements.get(mid)[0] > snapId) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}
		return elements.get(low)[1];
	}
}

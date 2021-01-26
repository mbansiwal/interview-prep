package google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
 

Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 

Constraints:

1 <= size <= 1000
-105 <= val <= 105
At most 104 calls will be made to next.

 * @author Administrator
 *
 */
public class MovingAverageFromDataStream {
	private Deque<Integer> queue;
	private int size;
	private int sum;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
    	sum+=val;
        if(queue.size() == size) {
        	sum-=queue.pollFirst();
        }
        queue.addLast(val);
        return (double)sum/queue.size();
    }
    
    public static void main(String[] args) {
		/**
		 * 
			["MovingAverage","next","next","next","next"]
			[[3],[1],[10],[3],[5]]
		 */
    	MovingAverageFromDataStream average = new MovingAverageFromDataStream(3);
    	System.out.println(average.next(1));
    	System.out.println(average.next(10));
    	System.out.println(average.next(3));
    	System.out.println(average.next(5));
	}
}

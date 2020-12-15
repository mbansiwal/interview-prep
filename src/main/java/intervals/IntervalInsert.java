package intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalInsert {
	public static void main(String[] args) {
		int[][] intervals = {{1,3},{6,9}};
		int[] newInterval = {2,5};
		System.out.println(insert(intervals, newInterval));
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while(i < intervals.length){
            int temp[] = intervals[i];
            if(temp[1] < newInterval[0]){
                result.add(temp);
                i++;
            } else{
                break;
            }
        }
        
        while(i < intervals.length){
            int temp[] = intervals[i];
            if(newInterval[1] >= temp[0]){
                newInterval[0] = Math.min(temp[0], newInterval[0]);
                newInterval[1] = Math.max(temp[1], newInterval[1]);
                i++;
            } else{
                break;
            } 
        }
        
        result.add(newInterval);
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}

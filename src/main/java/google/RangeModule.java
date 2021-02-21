package google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/range-module
 * 
A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.

addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
Example 1:
addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true (Every number in [10, 14) is being tracked)
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)

 * @author Administrator
 *
 */
class Interval implements Comparable<Interval>{
    int left;
    int right;

    public Interval(int left, int right){
        this.left = left;
        this.right = right;
    }

    public int compareTo(Interval that){
        if (this.right == that.right) return this.left - that.left;
        return this.right - that.right;
    }
}

public class RangeModule {
	TreeSet<Interval> treeSet;
	public RangeModule() {
        treeSet = new TreeSet<>();
    }
    
    public void addRange(int left, int right) {
        Iterator<Interval> itr = treeSet.tailSet(new Interval(0, left - 1)).iterator();
        
        while(itr.hasNext()) {
        	Interval current = itr.next();
        	if(right < left) {
        		break;
        	}
        	left = Math.min(left, current.left);
        	right = Math.max(current.right, right);
        	
        	itr.remove();
        }
        treeSet.add(new Interval(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        Interval iv = treeSet.higher(new Interval(0, left));
        return iv != null && iv.left <= left && right <= iv.right;
    }
    
    public void removeRange(int left, int right) {
    	Iterator<Interval> itr = treeSet.tailSet(new Interval(0, left)).iterator();
    	List<Interval> list = new ArrayList<>();
    	while(itr.hasNext()) {
    		Interval iv = itr.next();
    		if(right < iv.left) {
    			break;
    		}
    		
    		if(left > iv.left) {
    			list.add(new Interval(iv.left, left));
    		}
    		if(iv.right > right) {
    			list.add(new Interval(right, iv.right));
    		}
    		itr.remove();
    	}
    	for (Interval interval : list) {
			treeSet.add(interval);
		}
    }
}

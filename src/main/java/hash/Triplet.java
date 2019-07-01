package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Triplet
{
	public static List<List<Integer> > findTriplets(int[] nums, int sum)
    {
 
        /* Sort the elements */
        Arrays.sort(nums);
 
        List<List<Integer> > pair = new ArrayList<>();
        TreeSet<String> set = new TreeSet<String>();
        List<Integer> triplets = new ArrayList<>();
 
        /* Iterate over the array from the start and 
           consider it as the first element*/
        for (int i = 0; i < nums.length - 2; i++) {
 
            // index of the first element in the
            // remaining elements
            int j = i + 1;
 
            // index of the last element
            int k = nums.length - 1;
 
            while (j < k) {
 
                if (nums[i] + nums[j] + nums[k] == sum) {
 
                    String str = nums[i] + ":" + nums[j] + ":" + nums[k];
 
                    if (!set.contains(str)) {
                        // To check for the unique triplet
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        pair.add(triplets);
                        triplets = new ArrayList<>();
                        set.add(str);
                    }
 
                    j++; // increment the second value index
                    k--; // decrement the third value index
 
                } else if (nums[i] + nums[j] + nums[k] < sum)
                    j++;
 
                else // nums[i] + nums[j] + nums[k] > sum
                    k--;
            }
        }
        return pair;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 12, 3, 6, 1, 6, 9 };
        int sum = 24;
 
        List<List<Integer> > triplets = findTriplets(nums, sum);
 
        if (!triplets.isEmpty()) {
            System.out.println(triplets);
        } else {
            System.out.println("No triplets can be formed");
        }
    }
}

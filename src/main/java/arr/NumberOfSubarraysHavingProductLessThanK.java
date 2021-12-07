package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 
 
 * @author Administrator
 *
 */
public class NumberOfSubarraysHavingProductLessThanK {
    public static void main(String[] args)
    {
        List<Integer> arr = Arrays.asList( 2, 4, 5, 3 );
        System.out.println(
                countSubArrayProductLessThanK(arr, 12));

        ArrayList<Integer> al = new ArrayList<Integer> ();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(
                countSubArrayProductLessThanK(al, 10));

        ArrayList<Integer> al1 = new ArrayList<Integer> ();
        al1.add(1);
        al1.add(9);
        al1.add(2);
        al1.add(8);
        al1.add(6);
        al1.add(4);
        al1.add(3);
        System.out.println(
                countSubArrayProductLessThanK(al1, 100));

        ArrayList<Integer> al2 = new ArrayList<Integer> ();
        al2.add(5);
        al2.add(3);
        al2.add(2);
        System.out.println(
                countSubArrayProductLessThanK(al2, 16));

        ArrayList<Integer> al3 = new ArrayList<Integer> ();
        al3.add(100);
        al3.add(200);
        System.out.println(
                countSubArrayProductLessThanK(al3, 100));

        ArrayList<Integer> al4 = new ArrayList<Integer> ();
        al4.add(100);
        al4.add(200);
        System.out.println(
                countSubArrayProductLessThanK(al3, 101));


    }

    private static int countSubArrayProductLessThanK(List<Integer> al, int k) {
        int result = 0;
        int n = al.size();
        int end = 0;

        int product = 1;
        for(int start = 0; end < n; ++end){
            product = product*al.get(end);

            while(start < end && product >= k){
                product /= al.get(start++);
            }
            if(product < k){
                result += end - start + 1;
            }

        }
        return result;
    }
}

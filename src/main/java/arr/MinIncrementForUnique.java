package arr;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 * 
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

 * @author Administrator
 *
 */
public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> elements = new LinkedHashMap<>();

        for(int a:arr){
            elements.put(a, elements.getOrDefault(a, 0)+1);
        }

        int numberOfAttempts = 0;
        int duplicateElements = 0;
        int lastElement = 0;
        for(Map.Entry<Integer, Integer> element:elements.entrySet()){
            for(int i = lastElement+1; i < element.getKey() && duplicateElements > 0; ++i){
                --duplicateElements;
                numberOfAttempts += i;
            }

            if(element.getValue() >= 2){
                duplicateElements += element.getValue() -1;
                numberOfAttempts -= element.getKey()*(element.getValue() -1);
            }
            lastElement = element.getKey();
        }
        while(duplicateElements > 0){
            ++lastElement;
            --duplicateElements;
            numberOfAttempts += lastElement;
        }
        return numberOfAttempts;
    }

    public static void main(String[] args){
//        int arr[] = {1,2,2};
//        new MinIncrementForUnique().minIncrementForUnique(arr);

//        int arr1[] = {3,2,1,2,1,7};
//        new MinIncrementForUnique().minIncrementForUnique(arr1);

//        int arr2[] = {1,3,0,3,0};
//        System.out.println(new MinIncrementForUnique().minIncrementForUnique(arr2));

//        int arr3[] = {0,2,2};
//        System.out.println(new MinIncrementForUnique().minIncrementForUnique(arr3));
    	int arr3[] = {3,3,3};
        System.out.println(new MinIncrementForUnique().minIncrementForUnique(arr3));

    }
}

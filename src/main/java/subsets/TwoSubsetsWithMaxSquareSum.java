package subsets;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/divide-array-in-two-subsets-such-that-sum-of-square-of-sum-of-both-subsets-is-maximum/
 *
 * Divide array in two Subsets such that sum of square of sum of both subsets is maximum
 * Given an integer array arr[], the task is to divide this array into two non-empty subsets such that the sum of the square of the sum of both the subsets is maximum and sizes of both the subsets must not differ by more than 1.
 *
 * Examples:
 *
 * Input: arr[] = {1, 2, 3}
 * Output: 26
 * Explanation:
 * Sum of Subset Pairs are as follows
 * (1)2 + (2 + 3)2 = 26
 * (2)2 + (1 + 3)2 = 20
 * (3)2 + (1 + 2)2 = 18
 * Maximum among these is 26, Therefore the required sum is 26
 */
public class TwoSubsetsWithMaxSquareSum {
    public static int findMax(int[] arr){
        int aSum = 0;
        int bSum = 0;
        int length = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < length/2 - 1; ++i){
            aSum += arr[i];
        }
        for(int i =length/2 - 1; i < length; ++i){

            bSum += arr[i];
        }

        return aSum*aSum + bSum*bSum;
    }
    public static void main(String[] args){
        int arr[] = { 7, 2, 13, 4, 25, 8 };
        System.out.println(findMax(arr));
    }
}

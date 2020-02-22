package subsets;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/number-subsets-product-less-k/
 *
 * You are given an array of n-elements, you have to find the number of subsets whose product of elements is less than or equal to a given integer k.
 *
 * Examples:
 *
 * Input : arr[] = {2, 4, 5, 3}, k = 12
 * Output : 8
 * Explanation : All possible subsets whose
 * products are less than 12 are:
 * (2), (4), (5), (3), (2, 4), (2, 5), (2, 3), (4, 3)
 *
 * Input : arr[] = {12, 32, 21 }, k = 1
 * Output : 0
 * Explanation : there is not any subset such
 * that product of elements is less than 1
 *
 */
public class NumberOfSubsetsWithProductLessThanK {
    public static int findSubset(int[] arr,  int k){
        int n = arr.length;

        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();

        createSubSets(arr, new ArrayList<>(), leftSet, k, 0, n/2);
        createSubSets(arr, new ArrayList<>(), rightSet, k, n/2, n);

        List<Integer> leftArr = new ArrayList<>(leftSet);
        List<Integer> rightArr = new ArrayList<>(rightSet);
        Collections.sort(leftArr);
        Collections.sort(rightArr);

        int count = leftArr.size()+rightArr.size();
        for (Integer leftElement: leftArr) {
            count += binarySearch(rightArr, k/leftElement);
        }

        return count;
    }

    private static int binarySearch(List<Integer> list, int element){
        int n = list.size();
        int low = 0;
        int high = n-1;

        while(low <= high){
            int medium = (low+high)/2;
            if(list.get(medium) == element){
                return medium + 1;
            }
            else if(list.get(medium) > element){
                high = medium - 1;
            }
            else{
                low = medium + 1;
            }
        }

        return low;
    }


    private static void createSubSets(int[] arr, List<Integer> tempset, Set<Integer> subset, int k, int start, int end){
        if(!tempset.isEmpty()){
            int product = 1;
            subset.addAll(tempset);

            for (Integer data: tempset) {
                product *= data;
            }
            if(product <= k){
                subset.add(product);
            }
        }

        for(int i = start; i < end; ++i){
            if(arr[i] <= k){
                tempset.add(arr[i]);
                createSubSets(arr, tempset, subset, k, i+1, end);
                tempset.remove(tempset.size()-1);
            }
        }
    }

    public static void main(String[] args){
        int arr1[] = { 2, 4, 5, 3 };
        int k = 12;
        System.out.println(findSubset(arr1, k));

        int arr[] = { 4, 2, 3, 6, 5 };
        k = 25;
        System.out.println(findSubset(arr, k));

        int arr2[] = {12, 32, 21 };
        k = 1;
        System.out.println(findSubset(arr2, k));
    }
}

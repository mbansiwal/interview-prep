package arr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subArraySum(int[] nums, int sum) {
        int answer = 0;
        int n = nums.length;
        int currentSum = nums[0];
        int start = 0;
        for (int i=1; i <= n; ++i){
            while(currentSum > sum  && start < (i-1)){
                currentSum = currentSum - nums[start];
                start++;
            }

            if(currentSum == sum){
                answer++;
            }
            if(i < n)
            {
                currentSum += nums[i];
            }
        }

        return answer;
    }

    public static int subArraySumWithMap2(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int count = 0;
    	int currentSum = 0;
    	map.put(0, 1);
    	for (int i = 0; i < nums.length; i++) {
			currentSum+=nums[i];
			int diff = currentSum - k;
			if(map.containsKey(diff)) {
				count += map.get(diff);
			}
			map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
		}
    	return count;
    }
    
    public static int subArraySumWithMap(int[] nums, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        map.put(0, 1);
        int answer = 0;
        for (int i=0; i < nums.length; i++){
            currentSum += nums[i];
            if(map.containsKey(currentSum - sum)){
                answer += map.get(currentSum - sum);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args){
        int arr[] = {1,1,1};
        System.out.println(subArraySum(arr, 2));
        System.out.println(subArraySumWithMap(arr, 2));
        System.out.println(subArraySumWithMap2(arr, 2));
        System.out.println();
        int arr1[] = {1,2,3};
        System.out.println(subArraySum(arr1, 3));
        System.out.println(subArraySumWithMap(arr1, 3));
        System.out.println(subArraySumWithMap2(arr1, 3));
        System.out.println();
        int arr2[] = {-1,-1,1};
        System.out.println(subArraySumWithMap(arr2, 0));
        System.out.println(subArraySumWithMap(arr2, 0));
        System.out.println(subArraySumWithMap2(arr2, 0));
        System.out.println();
        System.out.println(subArraySumWithMap(arr2, 1));
        System.out.println(subArraySumWithMap(arr2, 1));
        System.out.println(subArraySumWithMap2(arr2, 1));
        System.out.println();
        int[] arr3 = {-92,-63,75,-86,-58,22,31,-16,-66,-67,420};
        System.out.println(subArraySumWithMap(arr3, 100));
        System.out.println(subArraySumWithMap(arr3, 100));
        System.out.println(subArraySumWithMap2(arr3, 100));
        System.out.println();
    }
}

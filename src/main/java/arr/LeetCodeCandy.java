package arr;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy
 */
public class LeetCodeCandy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }

    public int candy2(int[] ratings){
        int[] candies = new int[ratings.length];
        int n = ratings.length;
        Arrays.fill(candies, 1);
        for (int i = 1; i<n; ++i){
            if(ratings[i-1] < ratings[i]){
                candies[i] = candies[i-1] + 1;
            }
        }

        int sum = candies[n-1];
        for (int i = n-2; i>=0; --i){
            if(ratings[i+1] < ratings[i]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            sum+=candies[i];
        }
        return sum;
    }


    public static void main(String[] args){
        int arr1[] = {1,0,2};
        System.out.println(new LeetCodeCandy().candy(arr1));
        System.out.println(new LeetCodeCandy().candy2(arr1));

        int arr2[] = {1,2,2};
        System.out.println(new LeetCodeCandy().candy(arr2));
        System.out.println(new LeetCodeCandy().candy2(arr2));
    }
}

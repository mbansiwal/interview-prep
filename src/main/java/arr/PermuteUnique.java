package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteUniqueInternal(nums, result, new ArrayList<>(), used);
        return result;
    }


    private void permuteUniqueInternal(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used) {
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=0; i < nums.length; ++i){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            permuteUniqueInternal(nums, result, tempList, used);
            tempList.remove(tempList.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args){
        int[] input = {1,1,2};
        System.out.println(new PermuteUnique().permuteUnique(input));
    }
}

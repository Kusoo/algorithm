package leetcode.permutations_2;

import java.util.*;

/**
 * Created by l81022078 on 2017/8/3.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        Arrays.sort(nums);
        permute(nums, 0, result);
        return result;
    }

    private void permute(int[] nums, int start, List<List<Integer>> result){
        if(start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums)
                list.add(num);
            result.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[start]);
        for(int i = start; i < nums.length; i++){
            if(i == start || !set.contains(nums[i])){
                set.add(nums[i]);
                swap(nums, start, i);
                permute(nums, start + 1, result);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        new Solution().permuteUnique(new int[]{1,1,2});
    }
}

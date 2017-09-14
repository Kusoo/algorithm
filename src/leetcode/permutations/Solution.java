package leetcode.permutations;

import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by l81022078 on 2017/8/3.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        permute(nums, 0, result);
        return result;
    }

    private void permute(int[] nums, int start, List<List<Integer>> result){
        if(start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums)
                list.add(num);
            result.add(list);
        }
        for(int i = start; i < nums.length; i++){
            swap(nums, start, i);
            permute(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

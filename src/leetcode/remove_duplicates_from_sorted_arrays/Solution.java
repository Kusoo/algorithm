package leetcode.remove_duplicates_from_sorted_arrays;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int result = 0;
        for(int i = 1; i < len; i++){
            if(nums[i] != nums[result])
                nums[++result] = nums[i];
        }
        return ++result;
    }
}
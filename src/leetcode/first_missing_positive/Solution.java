package leetcode.first_missing_positive;

/**
 * Created by l81022078 on 2017/8/7.
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length;){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }else{
                i++;
            }
        }
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
}

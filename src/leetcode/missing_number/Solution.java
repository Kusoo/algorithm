package leetcode.missing_number;

/**
 * Created by l81022078 on 2017/8/28.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int ret = 0;
        int i = 0;
        for(int num : nums){
            ret ^= num;
            ret ^= i;
            i++;
        }
        return ret ^ i;
    }
}

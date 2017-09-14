package leetcode.jump_game;

/**
 * Created by l81022078 on 2017/8/9.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        int i = 0;
        while(max < len - 1){
            int temp = max;
            for(;i <= max; i++)
                temp = Math.max(temp, i + nums[i]);
            if(temp == max) return false;
            max = temp;
        }
        return true;
    }
}

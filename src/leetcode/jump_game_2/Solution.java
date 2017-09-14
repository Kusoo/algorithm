package leetcode.jump_game_2;

import java.util.Arrays;

/**
 * Created by l81022078 on 2017/8/3.
 */
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int max = 0;
        int level = 0;
        int i = 0;
        while(max < (len - 1)){
            int temp = max;
            for(;i <= max; i++)
                temp = Math.max(temp, i + nums[i]);
            max = temp;
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{1, 2}));
    }
}

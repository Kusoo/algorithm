package leetcode.trapping_rain_water;

import java.util.Map;

/**
 * Created by l81022078 on 2017/8/7.
 */
public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 0) return 0;
        int[] left = new int[len];
        int max  = left[0] = height[0];
        for(int i = 1; i < len; i++){
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        int[] right = new int[len];
        max = right[len - 1] = height[len - 1];
        for(int i = len - 2; i >=0; i--){
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            max = Math.min(left[i], right[i]);
            if(max > height[i])
                result += max - height[i];
        }
        return result;
    }
}

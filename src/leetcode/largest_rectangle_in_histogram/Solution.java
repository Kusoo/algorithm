package leetcode.largest_rectangle_in_histogram;

import java.util.Stack;

/**
 * Created by l81022078 on 2017/8/3.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int result = 0;
        for(int i = 0; i <= len; i++){
            int height = (i == len ? 0 : heights[i]);
            if(s.empty() || height >= heights[s.peek()])
                s.push(i);
            else{
                int tp = s.pop();
                result = Math.max(result, heights[tp] * (s.empty() ? i : (i - s.peek() - 1)));
                i--;
            }
        }
        return result;
    }
}

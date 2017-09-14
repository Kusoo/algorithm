package leetcode.candy;

import java.util.Arrays;

/**
 * Created by l81022078 on 2017/8/8.
 */
public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] arr = new int[len];
        Arrays.fill(arr, 1);
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i - 1])
                arr[i] = Math.max(arr[i], arr[i - 1] + 1);
        }
        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
        }
        int result = 0;
        for(int i = 0; i < len; i++)
            result += arr[i];
        return result;
    }
}

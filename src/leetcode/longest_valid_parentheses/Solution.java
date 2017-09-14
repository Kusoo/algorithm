package leetcode.longest_valid_parentheses;

/**
 * Created by l81022078 on 2017/8/2.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[len];
        int result = 0;
        if(len <= 1) return result;
        for(int i = 1; i < len; i++){
            if(arr[i] != '('){
                if(dp[i - 1] == 0 && arr[i - 1] == '('){
                    dp[i] = 2;
                }else if(dp[i - 1] != 0 && i - 1 - dp[i - 1] >= 0 && arr[i - 1 - dp[i - 1]] == '('){
                    dp[i] = dp[i - 1] + 2;
                }
                if(i - dp[i] >= 0)
                    dp[i] += dp[i - dp[i]];
                result = result > dp[i] ? result : dp[i];
            }
        }
        return result;
    }
}

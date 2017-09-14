package leetcode.decode_ways;

/**
 * Created by l81022078 on 2017/8/8.
 */
public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= len; i++){
            int num1 = s.charAt(i - 1) - '0';
            int num2 = s.charAt(i - 2) - '0';

            if(num1 == 0){
                if(num2 > 0 && num2 <= 2)
                    dp[i] = dp[i - 2];
                else
                    return 0;
            }else{
                if(num1 <= 6 && num2 > 0 && num2 <= 2)
                    dp[i] = dp[i - 1] + dp[i - 2];
                else if(num1 <= 9 && num2 == 1)
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}

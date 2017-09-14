package leetcode.wildcard_matching;

/**
 * Created by l81022078 on 2017/8/2.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            if(p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else
                break;
        }
        for(int i = 0; i < m; i++){
            char s_c =  s.charAt(i);
            for(int j = 0; j < n; j++){
                char p_c = p.charAt(j);
                if(p_c == '*'){
                    for(int k = i + 1; k >=0; k--){
                        if(dp[k][j]) {
                            dp[i + 1][j + 1] = true;
                            break;
                        }
                    }
                }else{
                    if(p_c == '?' || p_c == s_c)
                        dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
}

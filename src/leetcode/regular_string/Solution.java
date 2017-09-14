package leetcode.regular_string;

import java.util.function.Function;

public class Solution {

    /*
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <=n; j++){
                char p_c = p.charAt(i - 1);
                char s_c = s.charAt(j - 1);
                if(p_c == '.' || p_c == s_c){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p_c == '*') {
                    if(i == 1){
                        dp[i][j] = true;
                    }else {
                        for (int k = j; k >= 1; k--) {
                            if (dp[i - 1][k])
                                dp[i][j] = true;
                        }
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
    */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        if(n == 0){
            for(int i = 0; i < m; i++){
                if(p.charAt(i) != '*'){
                    if(i + 1 == m || p.charAt(i + 1) != '*')
                        return false;
                }
            }
            return true;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <=n; j++){
                char p_c = p.charAt(i - 1);
                char s_c = s.charAt(j - 1);
                if(p_c == '.' || p_c == s_c){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p_c == '*') {
                    dp[i][j - 1] |= dp[i - 2][j - 1];
                    if(s.charAt(j - 1) == p.charAt(i - 2) || p.charAt(i - 2) == '.'){
                        dp[i][j] = (dp[i][j - 1] || dp[i - 1][j] || dp[i - 2][j]);
                    }else{
                        dp[i][j] = dp[i - 2][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aab", "c*a*b"));
    }
}

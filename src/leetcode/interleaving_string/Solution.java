package leetcode.interleaving_string;

/**
 * Created by l81022078 on 2017/8/8.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int len = s3.length();
        if(m + n != len) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for(int i = 1; i <= n; i++){
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <=n; j++){
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    dp[i][j] |= dp[i - 1][j];
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    dp[i][j] |= dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new Solution().isInterleave("aa", "ab", "aaba");
    }
}

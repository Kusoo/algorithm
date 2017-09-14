package dp.digit_dp;

/**
 * Created by l81022078 on 2017/8/24.
 */
public class Solution {
    private int N = 10;
    private int[] digits = new int[N];
    private int[][] dp = new int[N][N];

    private int dfs(int x, int count, boolean limit){
        if(x < 0) return count;
        if(!limit && dp[x][count] != -1) return dp[x][count];
        int last = limit ? digits[x] : 9;
        int ret = 0;
        for(int i = 0; i <= last; i++){
            ret += dfs(x - 1, count + (i == 1 ? 1 : 0), limit && (i == last));
        }
        if(!limit){
            dp[x][count] = ret;
        }
        return ret;
    }

    public int countDigitOne(int n){
        int len = 0;
        while(n > 0){
            digits[len++] = n % 10;
            n /= 10;
        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = -1;
            }
        }
        return dfs(len - 1, 0, true);
    }
}

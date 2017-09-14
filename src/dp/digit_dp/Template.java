package dp.digit_dp;

/**
 * Created by l81022078 on 2017/8/21.
 */
public class Template {
    private int N = 10;
    private int[] digits = new int[N];
    private int[][][] dp = new int[N][10][2];

    private int dfs(int x, int pre, boolean bo, boolean limit){
        if(x < 0) return bo ? 1 : 0;
        if(!limit && dp[x][pre][bo ? 1 : 0] != -1) return dp[x][pre][bo ? 1 : 0];
        int last = limit ? digits[x] : 9;
        int ret = 0;
        for(int i = 0; i <= last; i++){
            ret += dfs(x - 1, i, bo || (i == 1), limit && (i == last));
        }
        if(!limit) dp[x][pre][bo ? 1 : 0] = ret;
        return ret;
    }

    public int solve(int n){
        int len = 0;
        while(n > 0){
            digits[len++] = n % 10;
            n /= 10;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(len - 1, 0, false, true);
    }
}

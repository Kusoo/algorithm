package hihocoder.week_162;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int len = 1; len < n; len++){
                for(int i = 0; i + len < n; i++){
                    int j = i + len;
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = Math.min(dp[i + 1][j - 1], dp[i][j - 1] + 1);
                    }else{
                        dp[i][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }
            System.out.println(dp[0][n - 1]);
        }
    }
}

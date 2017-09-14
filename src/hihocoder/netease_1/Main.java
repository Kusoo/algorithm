package hihocoder.netease_1;

import java.util.*;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    private static int expect = 0;
    private static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt() / 1024;
                sum += arr[i];
            }
            expect = sum >>> 1;
            int[] dp = new int[expect + 1];
            for(int i = 1; i <= n; i++){
                for(int j = expect; j >= arr[i - 1]; j--){
                    dp[j] = Math.max(dp[j], dp[j - arr[i - 1]] + arr[i - 1]);
                }
            }
            System.out.println((sum - dp[expect]) * 1024);
        }
        Collections.sort(new ArrayList<String>(), Collections.reverseOrder());
    }

}

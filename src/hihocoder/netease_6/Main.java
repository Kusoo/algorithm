package hihocoder.netease_6;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    private static int total = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int m = 6;
            int n = sc.nextInt();
            boolean[][] arr = new boolean[m][n];
            for(int i = 0 ; i < n; i++){
                String str = sc.next();
                for(char c : str.toCharArray()){
                    arr[c - '0'][i] = true;
                }
            }
            total = 0;
            dfs(arr, new boolean[n], 0, m, n);
            System.out.println(total);
        }
    }

    private static void dfs(boolean arr[][], boolean[] flag, int index, int m, int n){
        if(index == m){
            for(int i = 0; i < n; i++){
                if(!flag[i]) return;
            }
            total++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(arr[index][i]){
                boolean cache = flag[i];
                flag[i] = true;
                dfs(arr, flag, index + 1, m, n);
                flag[i] = cache;
            }
        }
    }
}

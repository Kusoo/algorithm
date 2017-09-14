package hihocoder.netease_9;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            char[][] arr = new char[n][n];
            for(int i = 0; i < n; i++){
                char[] temp = sc.next().toCharArray();
                for(int j = 0; j < n; j++){
                    arr[j][i] = temp[j];
                }
            }
            int result = 1;
            for(int i = 0; i < n; i++){
                int max = 1;
                int cur = 1;
                for(int j = 1; j < n; j++){
                    if(arr[i][j] == arr[i][j - 1])
                        cur++;
                    else {
                        max = Math.max(max, cur);
                        cur = 1;
                    }
                }
                max = Math.max(max, cur);
                result = Math.max(result, max);
            }
            System.out.println(result);
        }
    }
}

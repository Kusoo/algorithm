package hihocoder.netease_11;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println(sum);
            if((sum & 1) == 1) {
                System.out.println("-1");
            }else{
                sum = sum >>> 1;
                if(dfs(arr, 0, sum, 0))
                    System.out.println(sum);
                else
                    System.out.println("-1");
            }
        }
    }

    private static boolean dfs(int[] arr, int sum, int dest, int index){
        if(sum == dest) return true;
        if(sum > dest) return false;
        if(index >= arr.length) return false;
        if(dfs(arr, arr[index] + sum, dest, index + 1))
            return true;
        if(dfs(arr, sum, dest, index + 1)) return true;
        return false;
    }
}

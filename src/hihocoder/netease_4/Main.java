package hihocoder.netease_4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                map.put(arr[i], i);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                if(i == map.get(arr[i])){
                    sb.append(arr[i]);
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}

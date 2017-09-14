package hihocoder.netease_10;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            HashSet<String> rem = new HashSet<>();
            HashSet<String> dic = new HashSet<>();
            for(int i = 0; i < m; i++){
                rem.add(sc.next());
            }
            for(int i = 0; i < n; i++){
                dic.add(sc.next());
            }
            int score = 0;
            for(String str : rem){
                if(dic.contains(str)){
                    score += str.length() * str.length();
                }
            }
            System.out.println(score);
        }
    }
}

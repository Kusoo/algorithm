package hihocoder.netease_3;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            int min = Math.min(times(str, 'B'), times(str, 'G'));
            System.out.println(min);
        }
    }

    private static int times(String str, char c){
        int start = 0;
        int ret = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){
                ret += i - start;
                start++;
            }
        }
        return ret;
    }
}

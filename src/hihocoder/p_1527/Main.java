package hihocoder.p_1527;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            String[] arr = s.split("0+");
            int result = 0;
            for(String str : arr){
                if(str.length() == 1) result += 1;
                else result += 2;
            }
            result += result - 1;
            System.out.println(result);
        }
    }
}

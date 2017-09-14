package hihocoder.netease_8;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            char[] arr = str.toCharArray();
            int result = arr[0] - '0';
            for(int i = 1; i < arr.length; i+=2){
                char operator = str.charAt(i);
                int number = str.charAt(i + 1) - '0';
                if(operator == '+'){
                    result += number;
                }else if(operator == '-'){
                    result -= number;
                }else if(operator == '*'){
                    result *= number;
                }
            }
            System.out.println(result);
        }
    }
}

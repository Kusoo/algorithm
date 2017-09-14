package qpow;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class QPow {
    public int pow(int a, int b){
        int base = a;
        int result = 1;
        while(b != 0){
            if((b & 1) == 1){
                result *= base;
            }
            base *= base;
            b = b >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new QPow().pow(4, 2));
    }
}

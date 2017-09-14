package pow;

public class Pow {
    int N = 50;
    double pow(double x){
        double temp = 0f;
        for(int i = 1; i <= N; i++){
            if((i + 1) % 2 == 0)
                temp += 1.0f / i;
            else
                temp -= 1.0f / i;
        }
        temp *= x;
        double result = 1f;
        for(int i = 1; i <= N; i++){
            double a = 1.0f;
            long b = 1;
            for(int j = 1; j <= i; j++){
                a *= temp;
                b *= j;
            }
            result += a / b;
        }
        return result;
    }

    public static void main(String[] args) {
        double n = 5;
        double a = Math.pow(2, n);
        double b = new Pow().pow(n);
        System.out.println(a);
        System.out.println(b);
    }
}

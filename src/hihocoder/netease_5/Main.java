package hihocoder.netease_5;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                matrix[i][i] = 1;
                matrix[i + 1 == n ? 0 : i + 1][i] = 1;
            }
            int[][] product = new int[n][n];
            for(int i = 0; i < n; i++){
                product[i][i] = 1;
            }
            while(k != 0){
                if((k & 1) == 1)
                    product = multi(product, matrix);
                matrix = multi(matrix, matrix);
                k = k >>> 1;
            }
            int[] ret = multi(arr, product);
            StringBuilder sb = new StringBuilder();
            for(int num : ret){
                sb.append(num);
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static int[][] multi(int[][] matrix1, int[][] matrix2){
        int n = matrix1.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    result[i][j] %= 100;
                }
            }
        }
        return result;
    }
    private static int[] multi(int[] arr, int[][] matrix){
        int n = arr.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i] += arr[j] * matrix[j][i];
                result[i] %= 100;
            }
        }
        return result;
    }
}

package sort;

import java.util.Arrays;

/**
 * Created by l81022078 on 2017/8/22.
 */
public class RadixSort {
    public int[] sort(int[] arr){
        int len = arr.length;
        int max = arr[0];
        for(int i = 1; i < len; i++){
            max = Math.max(max, arr[i]);
        }
        int radix = 1;
        while(max / radix > 0){
            int[] output = new int[len];
            int[] count = new int[10];

            for(int i = 0; i < len; i++){
                count[(arr[i] / radix) % 10]++;
            }

            for(int i = 1; i < 10; i++){
                count[i] += count[i - 1];
            }

            for(int i = len - 1; i >= 0; i--){
                output[--count[(arr[i] / radix) % 10]] = arr[i];
            }

            for(int i = 0; i < len; i++){
                arr[i] = output[i];
            }

            radix *= 10;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new RadixSort().sort(new int[]{19, 7, 5, 33});
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}

package kmp;

/**
 * Created by l81022078 on 2017/7/31.
 */
public class KMP {
    public static boolean match(String src, String pattern){
        int m = pattern.length();
        int n = src.length();
        int[] next = getNext(pattern);
        for(int i = 0, j = 0; i < n; i++){
            while(j > 0 && src.charAt(i) != pattern.charAt(j))
                j = next[j - 1];
            if(src.charAt(i) == pattern.charAt(j))
                j++;
            if(j == m)
                return true;
        }
        return false;
    }

    private static int[] getNext(String pattern){
        char[] arr = pattern.toCharArray();
        int len = arr.length;
        int[] next = new int[len];
        for(int i = 1; i < len; i++){
            int k = next[i - 1];
            while(k > 0 && arr[i] != arr[k]){
                k = next[k - 1];
            }
            if(arr[i] == arr[k])
                k++;
            next[i] = k;

        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(match("AABDC", "ABD"));
    }
}

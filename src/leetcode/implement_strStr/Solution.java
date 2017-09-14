package leetcode.implement_strStr;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int h_len = haystack.length();
        int n_len = needle.length();
        if(n_len == 0)
            return 0;
        if(h_len == 0)
            return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int[] next = getNext(n);
        for(int i = 0, j = 0; i < h_len; i++){
            while(j > 0 && h[i] != n[j])
                j = next[j - 1];
            if(h[i] == n[j]){
                j++;
            }
            if(j == n_len)
                return i - j + 1;
        }
        return -1;
    }

    private int[] getNext(char[] needle){
        int len = needle.length;
        int[] next = new int[len];
        for(int i = 1; i < len; i++){
            int k = next[i - 1];
            while(k > 0 && needle[i] != needle[k])
                k = next[k - 1];
            if(needle[i] == needle[k])
                k++;
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        new Solution().strStr("mississippi", "issip");
    }
}

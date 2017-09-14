package leetcode.remove_duplicate_letters;

/**
 * Created by l81022078 on 2017/8/28.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int[] count = new int[26];
        boolean[] flag = new boolean[26];

        for (char c : arr) {
            count[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0;
        while (l < len) {
            int min = 27;
            int index = l;
            for (r = l; r < len; r++) {
                int id = arr[r] - 'a';
                if (flag[id]) continue;
                if (id < min) {
                    min = id;
                    index = r;
                }
                if (--count[id++] == 0){
                    r++;
                    break;
                }
            }
            if(min == 27) break;
            for (int i = index; i < r; i++) {
                count[arr[i] - 'a']++;
            }
            flag[min] = true;
            sb.append((char) ('0' + min));
            l = index + 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().removeDuplicateLetters("bcabc");
    }
}

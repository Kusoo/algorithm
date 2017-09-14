package leetcode.longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int index = 0;
        int len = strs.length;
        if(len != 0) {
            String first = strs[0];
            while(true){
                for(String str : strs){
                    if(str.length() <= index || str.charAt(index) != first.charAt(index))
                        return result;
                }
                result += first.charAt(index);
                index++;
            }
        }
        return result;
    }
}

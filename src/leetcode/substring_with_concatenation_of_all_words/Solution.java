package leetcode.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by l81022078 on 2017/8/7.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int num = words.length;
        int len = words[0].length();

        List<Integer> result = new ArrayList<>();
        for(int k = 0; k < len; k++){
            HashMap<String, Integer> map = new HashMap<>();
            for(String word : words){
                if(map.containsKey(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);
            }
            int left = k;
            int right = k;
            int count = 0;
            while(right <= s.length() - len){
                String slice = s.substring(right, right + len);
                if(map.containsKey(slice)){
                    map.put(slice, map.get(slice) - 1);
                    if(map.get(slice) >= 0) count++;
                    while(count == num){
                        if((right - left + len) == (num * len))
                            result.add(left);
                        slice = s.substring(left, left + len);
                        if(map.containsKey(slice)){
                            map.put(slice, map.get(slice) + 1);
                            if(map.get(slice) > 0)
                                count--;
                        }
                        left += len;
                    }
                }
                right += len;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
    }
}

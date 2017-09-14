package leetcode.text_justification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by l81022078 on 2017/8/4.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        List<String> arr = new ArrayList<>();
        int width = 0;
        for(int i = 0; i < words.length; i++){
            int size = arr.size();
            if(width + size + words[i].length() <= maxWidth){
                arr.add(words[i]);
                width += words[i].length();
            }else{
                result.add(getLine(arr, width, maxWidth, false));
                width = 0;
                arr.clear();
                i--;
            }
        }
        result.add(getLine(arr, width, maxWidth, true));
        return result;
    }

    private String getLine(List<String> arr, int width, int maxWidth, boolean flag){
        StringBuilder sb = new StringBuilder(maxWidth);
        int size = arr.size();
        if(flag){
            sb.append(arr.get(0));
            for(int i = 1; i < size; i++){
                sb.append(" ");
                sb.append(arr.get(i));
            }
            char[] space = new char[maxWidth - width- (size - 1)];
            Arrays.fill(space, ' ');
            sb.append(space);
            return sb.toString();
        }
        if(size == 1) {
            sb.append(arr.get(0));
            char[] space = new char[maxWidth - width];
            Arrays.fill(space, ' ');
            sb.append(space);
        }else{
            int more_space = maxWidth - width - (size - 1);
            int avg = more_space / (size - 1) + 1;
            char[] space = new char[avg];
            Arrays.fill(space, ' ');
            int left = more_space % (size - 1);
            sb.append(arr.get(0));
            for(int i = 1; i < size; i++){
                sb.append(space);
                if(i <= left)
                    sb.append(" ");
                sb.append(arr.get(i));
            }
        }

        return sb.toString();
    }
}

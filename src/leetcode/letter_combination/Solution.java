package leetcode.letter_combination;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits.length() == 0) return result;
        String[] mappings = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.offer("");
        for(int i = 0; i < digits.length(); i++){
            int index = digits.charAt(i) - '0';
            while(result.peek().length() == i){
                String s = result.poll();
                for(char c : mappings[index].toCharArray()){
                    result.offer(s + c);
                }
            }
        }
        return result;
    }
}

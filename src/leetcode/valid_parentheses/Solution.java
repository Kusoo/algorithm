package leetcode.valid_parentheses;

import java.util.Stack;

/**
 * Created by l81022078 on 2017/8/1.
 */
public class Solution {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char e = '(';
            boolean flag = true;
            if(c == ')')
                e = '(';
            else if(c == ']')
                e = '[';
            else if(c == '}')
                e = '{';
            else
                flag = false;
            if(flag){
                if(stack.empty()) return false;
                char t = stack.peek();
                if(t == e)
                    stack.pop();
                else
                    stack.push(c);
            }else{
                stack.push(c);
            }
        }
        return stack.empty();
    }
}

package leetcode.palindrome_number;

/**
 * Created by l81022078 on 2017/6/1.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        int z = x;
        if(z < 0) return false;
        int y = 0;
        while(z != 0){
            y = y * 10 + z % 10;
            z /= 10;
        }
        if(x == y) return true;
        return false;
    }
}

package leetcode.reverse_integer;


public class Solution {
    public int reverse(int x) {
        int result = 0;
        int y = x < 0 ? -x : x;
        while(y > 0){
            int oldResult = result;
            result = result * 10 + y % 10;
            if((result - y % 10) / 10 != oldResult) return 0;
            y /= 10;
        }
        if( x < 0) return -result;
        return result;
    }

    public static void main(String[] args) {
        new Solution().reverse(1534236469);
    }
}

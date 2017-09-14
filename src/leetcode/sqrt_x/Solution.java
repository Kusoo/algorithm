package leetcode.sqrt_x;

/**
 * Created by l81022078 on 2017/8/7.
 */
public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int start = 1;
        int end = 46340;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            int tmp = mid * mid;
            if(tmp == x)
                return mid;
            else if(tmp > x) {
                if((mid - 1) * (mid - 1) <= x)
                    return mid - 1;
                end = mid - 1;
            }else {
                if((mid + 1) * (mid + 1) > x)
                    return mid;
                start = mid + 1;
            }

        }
        return mid;
    }
}

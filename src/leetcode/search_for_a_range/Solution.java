package leetcode.search_for_a_range;

/**
 * Created by l81022078 on 2017/8/3.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return new int[]{-1, -1};
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target)
                break;
            else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(nums[mid] == target){
            int i = mid, j = mid;
            while(i > 0 && nums[i - 1] == target)
                i--;
            while(j < len - 1 && nums[j + 1] == target)
                j++;
            return new int[]{i, j};
        }else
            return new int[]{-1, -1};
    }
}

package leetcode.n_queens;

/**
 * Created by l81022078 on 2017/8/7.
 */
public class Solution {
    public int totalNQueens(int n) {
        int[] result = new int[]{0};
        int[] arr = new int[n + 1];
        dfs(arr, 1, result);
        return result[0];
    }

    private void dfs(int[] arr, int k, int[] result){
        int n = arr.length - 1;
        for(int i = 1; i <= n; i++){
            arr[k] = i;
            if(isValid(arr, k)){
                if(k == n) result[0]++;
                else
                    dfs(arr, k + 1, result);
            }
        }
    }

    private boolean isValid(int[] arr, int k){
        for(int i = 1; i < k; i++){
            if(arr[i] == arr[k] || (k - i) == Math.abs(arr[i] - arr[k]))
                return false;
        }
        return true;
    }
}

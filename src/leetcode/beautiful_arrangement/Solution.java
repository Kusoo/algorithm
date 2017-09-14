package leetcode.beautiful_arrangement;

/**
 * Created by l81022078 on 2017/9/13.
 */
class Solution {
    private int ret = 0;

    public int countArrangement(int N) {
        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }
        ret = 0;
        dfs(arr, 1, N);
        return ret;
    }

    private void dfs(int[] arr, int i, int N){
        if(i > N){
            ret++;
            return;
        }
        for(int k = i; k <= N; k++){
            swap(arr, i, k);
            if(satisfy(arr, i))
                dfs(arr, i + 1, N);
            swap(arr, i, k);
        }
    }

    private boolean satisfy(int[] arr, int i){
        if(arr[i] % i == 0 || i % arr[i] == 0)
            return true;
        return false;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        new Solution().countArrangement(1);
    }
}

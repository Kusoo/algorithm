package leetcode.permutation_sequence;

import java.util.ArrayList;

/**
 * Created by l81022078 on 2017/8/9.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            arr.add(i);
            fact[i] = fact[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for(int i = 1; i <= n; i++){
            int index = k / fact[n - i];
            sb.append(arr.get(index));
            arr.remove(index);
            k = k - index * fact[n - i];
        }
        return sb.toString();
    }
}

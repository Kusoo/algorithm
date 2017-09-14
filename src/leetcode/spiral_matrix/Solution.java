package leetcode.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l81022078 on 2017/8/9.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
        int m1 = 0, n1 = 0, m2 = matrix.length - 1, n2 = matrix[0].length - 1;
        while (m1 <= m2 && n1 <= n2) {
            walk(matrix, result, m1, n1, m2, n2);
            m1++;
            n1++;
            m2--;
            n2--;
        }
        return result;
    }

    private void walk(int[][] matrix, List<Integer> result, int m1, int n1, int m2, int n2) {
        if(m1 == m2){
            for(int j = n1; j <= n2; j++)
                result.add(matrix[m1][j]);
        }else if(n1 == n2){
            for(int i = m1; i <= m2; i++)
                result.add(matrix[i][n1]);
        }else{
            for(int j = n1; j <= n2; j++){
                result.add(matrix[m1][j]);
            }
            for(int i = m1 + 1; i < m2; i++){
                result.add(matrix[i][n2]);
            }
            for(int j = n2; j >= n1; j--){
                result.add(matrix[m2][j]);
            }
            for(int i = m2 - 1; i > m1; i--){
                result.add(matrix[i][n1]);
            }
        }
    }
}

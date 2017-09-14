package leetcode.generate_parentheses;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] record = new char[2 * n];
        dfs(0, n, 0, record, result);
        return result;
    }

    private void dfs(int index, int n, int sum, char[] record, List<String> result){
        if(n == 0){
            for(int i = index; i < record.length; i++){
                record[i] = ')';
            }
            result.add(new String(record));
            return;
        }
        if(sum > 0){
            record[index] = '(';
            dfs(index + 1, n - 1, sum + 1, record, result);

            record[index] = ')';
            dfs(index + 1, n, sum - 1, record, result);
        }else{
            record[index] = '(';
            dfs(index + 1, n - 1, sum + 1, record, result);
        }
    }
}

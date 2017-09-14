package leetcode.restore_ip_addresses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by l81022078 on 2017/8/9.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        dfs(s, 0, s.length(), 0, new int[4], result);
        return result;
    }

    private void dfs(String s, int start, int end, int num, int[] tmp, List<String> result){
        if(start >= end) return;
        if(num == 3){
            int cur = parse(s.substring(start));
            if(cur != - 1){
                tmp[3] = cur;
                StringBuilder sb = new StringBuilder();
                sb.append(tmp[0]);
                for(int i = 1; i < 4; i++){
                    sb.append(".");
                    sb.append(tmp[i]);
                }
                result.add(sb.toString());
            }
            return;
        }
        for(int i = 1; i <= 3 && start + i <= end; i++){
            int cur = parse(s.substring(start, start + i));
            if(cur != - 1){
                tmp[num] = cur;
                dfs(s, start + i, end, num + 1, tmp, result);
            }
        }
    }

    private int parse(String s){
        if(s.length() > 3) return -1;
        if(s.charAt(0) == '0' && s.length() > 1) return -1;
        int num = Integer.parseInt(s);
        if(num <= 255) return num;
        return -1;
    }
}

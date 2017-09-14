package leetcode.merge_intervals;

import java.util.Collections;
import java.util.List;

/**
 * Created by l81022078 on 2017/8/4.
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (src, dest) -> Integer.compare(src.start, dest.start));
        int len = intervals.size();
        if(len <= 1) return intervals;
        int prev = 0;
        for(int i = 1; i < len; i++){
            Interval pre = intervals.get(prev);
            Interval cur = intervals.get(i);

            if(cur.start > pre.end){
                intervals.set(++prev, cur);
            }else{
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        return intervals.subList(0, prev + 1);
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
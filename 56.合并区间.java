import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        int[]cur = intervals[0];
        for (int i = 0; i < intervals.length; ++i) {
            if(cur[1]>=intervals[i][0]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }else{
                merged.add(cur);
                cur = intervals[i];
            }
        }
        merged.add(cur);
        return merged.toArray(new int[merged.size()][]);
    }
}


// @lc code=end


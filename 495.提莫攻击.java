/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==1){
            return duration;
        }
        int sumtimes = 0;
        for(int i=1;i<timeSeries.length;++i){
            sumtimes+=Math.min(duration, timeSeries[i]-timeSeries[i-1]);
        }
        sumtimes+=duration;
        return sumtimes;

    }
}
// @lc code=end


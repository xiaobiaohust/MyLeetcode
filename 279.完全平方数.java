/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
/**
 * 动态规划
 * 使用dp数组，dp[i]表示和等于i的完全平方数个数
 * 类似字符串有空串，当i为0的时候，为0，所以定义一个n+1的dp
 */
class Solution {
    public int numSquares(int n) {
        int[]dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<n+1;++i){
            dp[i] = i;
            for(int j=1;i-j*j>=0;++j){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
// @lc code=end


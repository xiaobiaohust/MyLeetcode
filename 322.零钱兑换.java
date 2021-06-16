import jdk.nashorn.internal.runtime.arrays.IntElements;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
/**
 * 动态规划
 * 1、先求第一行，第一列
 * 2、dp[i][j] = min(dp[i][j-coins[i]],dp[i-1][j])
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][]dp = new int[coins.length][amount+1];
        for(int j=1;j<amount+1;++j){
            dp[0][j] = Integer.MAX_VALUE;
            if(j%coins[0]==0){
                dp[0][j] = j/coins[0];
            }
        }
        for(int i=1;i<coins.length;++i){
            for(int j=1;j<amount+1;++j){
                dp[i][j] = Integer.MAX_VALUE;
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                if(j-coins[i]>=0&&dp[i][j-coins[i]]!=Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]]+1);
                }
            }
        }
        return dp[coins.length-1][amount]==Integer.MAX_VALUE?-1:dp[coins.length-1][amount];
    }
}
// @lc code=end


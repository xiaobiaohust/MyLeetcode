/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
/**
 * 动态规划
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int[][]dp  = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int j=n-2;j>-1;--j){
            dp[m-1][j] = dp[m-1][j+1]+grid[m-1][j];
        }
        for(int i=m-2;i>-1;--i){
            dp[i][n-1] = dp[i+1][n-1]+grid[i][n-1];
        }
        for(int i=m-2;i>-1;--i){
            for(int j=n-2;j>-1;--j){
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])+grid[i][j];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end


import java.util.concurrent.ForkJoinPool;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
/**
 * 动态规划
 * 
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int j=n-1;j>-1;--j){
            if(obstacleGrid[m-1][j]==1){
                break;
            }
            dp[m-1][j] = 1;
        }
        for(int i=m-1;i>-1;--i){
            if(obstacleGrid[i][n-1]==1){
                break;
            }
            dp[i][n-1]=1;
        }
        for(int i=m-2;i>-1;--i){
            for(int j=n-2;j>-1;--j){
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end


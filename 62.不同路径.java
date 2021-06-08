import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
/**
 * 动态规划
 * dp[i][j]表示从i,j到达右下角的路径有多少
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m-1], 1);
        for(int i=0;i<m-1;++i){
            dp[i][n-1] = 1;
        }
        for(int i=m-2;i>-1;--i){
            for(int j=n-2;j>-1;--j){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
/**
 * 方案一、求直方图面积
 * 和求最大矩形面积类似，只不过额外加个正方形限制
 * 方案二、动态规划
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col= matrix[0].length;
        int[][]dp = new int[row][col];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<row;++i){
            dp[i][0] = matrix[i][0]=='1'?1:0;
            max = Math.max(max, dp[i][0]);
        }
        for(int j=1;j<col;++j){
            dp[0][j] = matrix[0][j]=='1'?1:0;
            max = Math.max(max, dp[0][j]);

        }
        for(int i=1;i<row;++i){
            for(int j=1;j<col;++j){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;

    }
}
// @lc code=end


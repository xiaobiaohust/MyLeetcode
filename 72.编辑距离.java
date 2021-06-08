import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
/**
 * 动态规划
 * dp[i][j]b
 */
class Solution {
    public int minDistance(String word1, String word2) {
        char[]s = word1.toCharArray();
        char[]t = word2.toCharArray();
        int m = s.length;
        int n = t.length;
        int [][]dp = new int[m+1][n+1];
        for(int j=1;j<n+1;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<m+1;++i){
            dp[i][0]= i;
        }
        for(int i=1;i<m+1;++i){
            for(int j=1;j<n+1;++j){
                dp[i][j] =  s[i-1]==t[j-1]? dp[i-1][j-1]:dp[i-1][j-1]+1;
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                
            }
        }
        return dp[m][n];
    }
}
// @lc code=end


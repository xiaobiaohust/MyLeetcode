/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
/**
 * 动态规划
 * dp[i][j]表示子串[i~j]是否是回文串
 * 从下到上，从左到右计算
 * 
 */
class Solution {
    public int countSubstrings(String s) {
        int maxlen = 0;
        char[]ss = s.toCharArray();
        int len = s.length();
        boolean [][]dp = new boolean[len][len];
        for(int j=0;j<len;++j){
            for(int i=j;i>-1;--i){
                if(ss[i]==ss[j]&&(j-i<=2||dp[i+1][j-1])){
                    dp[i][j] = true;
                    maxlen++;
                }
            }
        }
        return maxlen;
    }
}
// @lc code=end


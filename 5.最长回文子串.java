/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;
        int maxlen = Integer.MIN_VALUE;
        int start = -1;
        boolean [][]dp= new boolean[len][len];
        dp[0][0] = true;
        for(int j=1;j<len;++j){
            for(int i=j;i>=0;--i){
                if(i==j){
                    dp[i][j] = true;
                }else if(i+1==j){
                    dp[i][j]=ss[i]==ss[j]?true:false;
                }else{
                    dp[i][j]=ss[i]==ss[j]?dp[i+1][j-1]:false;
                }
                if(dp[i][j]&&(j-i+1>maxlen)){
                    maxlen = j-i+1;
                    start = i;
                }
            }
        }
        return start==-1?s:s.substring(start, start+maxlen);
    }
}
// @lc code=end


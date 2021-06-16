import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
/**
 * 动态规划
 * dp[i]表示以nums[i]结尾的递增子序列的最大长度
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[]dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxlen = 1;
        for(int i=1;i<nums.length;++i){
            for(int j=0;j<i;++j){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }
}
// @lc code=end


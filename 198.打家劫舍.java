/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
/**
 * 动态规划
 * 相邻的两个房间不能都选择，假设选择了一个房间，则其左右房间都不能选择，可以使用dp数组
 * dp[i]表示房间0~i所能得到的最多钱，dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i])
 * 
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;++i){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];

    }
}
// @lc code=end


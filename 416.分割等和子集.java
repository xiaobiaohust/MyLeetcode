import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
/**
 * 思想：
 * 1、求整个数组和，为奇数则不能分为两个子集，为偶数，取半，然后看是否有子集的和等于和的一半，
 * 2、求子集的和等于特定的数，和找硬币是一样的,有多少种找硬币方式
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;++i){
            sum+=nums[i];
        }
        if((sum&1)==1){
            return false;
        }

        sum/=2;
        boolean[][] dp= new boolean[nums.length][sum+1];
        for(int i =0;i<nums.length;++i){
            dp[i][0] = true;
        }
        if(sum>=nums[0]){
            dp[0][nums[0]] = true;
        }
        for(int i=1;i<nums.length;++i){
            for(int j=1;j<sum+1;++j){
                if(j-nums[i]>=0&&dp[i-1][j-nums[i]]){
                    dp[i][j]= true;
                }else{
                dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][sum];
    }
}
// @lc code=end


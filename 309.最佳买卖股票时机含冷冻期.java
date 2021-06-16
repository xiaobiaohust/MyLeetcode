/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
/**
 * 动态规划
 * dp[i]表示在第i天，能挣多少钱,必须第i天之前已经卖了，并且没有在买入
 * 计算dp[i]
 * 1、如果在第i天卖的，那么可以在之前任意一天买入,可能买卖操作了一次，也可能买卖操作了多次
 * 2、在第i天之前卖的，则dp[i]= dp[i-1]
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        if(prices.length==2)return prices[1]>prices[0]?prices[1]-prices[0]:0;
        int[]dp =new int[prices.length];
        dp[0] = 0;
        dp[1] = prices[1]>prices[0]?prices[1]-prices[0]:0;
        int maxfit = Math.max(dp[0], dp[1]);
        int min = Math.min(prices[0], prices[1]);
        for(int i=2;i<prices.length;++i){
            //买卖操作了一次
            dp[i] = prices[i]>min?prices[i]-min:0;
            //买卖操作了多次，进行遍历
            for(int j=i-1;j-2>0;--j){
                dp[i] = Math.max(dp[i], prices[i]-prices[j]+dp[j-2]);
            }
            //第i天没有卖
            dp[i] = Math.max(dp[i], dp[i-1]);
            min = Math.min(min, prices[i]);
            maxfit = Math.max(maxfit, dp[i]);
        }
        return maxfit;
    }
}
// @lc code=end


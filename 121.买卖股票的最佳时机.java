/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        
        int len= prices.length;
        if(len<2){
            return 0;
        }
        int[] minArr = new int[len];
        minArr[1] = prices[0];
        for(int i=2;i<len;++i){
            minArr[i]=Math.min(minArr[i-1], prices[i-1]);
        }
        int max = 0;
        for(int i=1;i<len;++i){
            max = Math.max(max, prices[i]-minArr[i]);
        }
        return max<0?0:max;
    }
}
// @lc code=end


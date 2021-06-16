/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
/**
 * 思想一、回溯法
 * 每次没有戳中任意一个气球，且之后不能在戳破该气球，由于数组长度比较长，回溯法解法太多，而且并不是要求所有的解法，没必要使用
 * 
 * 思想二、动态规划
 * 像这种可行的措施太多，每一次可以戳中任意一个气球，一般可以考虑动态规划
 * 1、戳气球会将不相邻的气球变得相邻，所以倒过来，一个个往里面放气球，求获得的硬币最大数量
 * 2、dp[i][j]表示数组(i,j)能获得的硬币最大数量
 * 3、
 *      dp[i][j] = dp[i][k]+arr[i]*arr[k]*arr[j]+dp[k][j]    i<k<j
 * 4、为了防止边界越界，我们左右各添加一个元素
 */
class Solution {
    public int maxCoins(int[] nums) {
        int len= nums.length;
        int[] arr = new int[len+2];
        arr[0] = 1;
        arr[len+1]= 1;
        for(int i=1;i<len+1;++i){
            arr[i] = nums[i-1];
        }
        int dp[][] = new int[len+2][len+2];
        for(int i=len-1;i>-1;--i){
            for(int j=i+2;j<len+2;++j){
                for(int k=i+1;k<j;++k){
                    int sum = arr[i]*arr[k]*arr[j];
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k][j]+sum);
                }
            }
        }
        return dp[0][len+1];
    }
}
// @lc code=end


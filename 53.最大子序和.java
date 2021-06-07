/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int i=0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while(i<nums.length){
            sum+=nums[i++];
            max = Math.max(max, sum);
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
}
// @lc code=end


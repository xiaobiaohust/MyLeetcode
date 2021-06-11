/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
/**
 * 使用max，min记录最小值
 */
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return nums[0];
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;++i){
            int temp  =max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
            if(max>res) res = max;
        }
        return res;
    }
}
// @lc code=end


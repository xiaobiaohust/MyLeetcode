/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */
/**
 * 1、回溯法
 * 每个元素可以是正也可以是负。时间复杂度可能很高
 * 2、动态规划，
 * 假设nums数组的和为sum,则所有负数的和为(sum-targrt)/2,只需选择负数使得其和为上述值就行
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] record = new int[1];
        backtrack(record, nums, 0, 0, target);
        return record[0];

    }
    private void backtrack(int []record,int[]nums,int start,int sum,int target){
        if(start==nums.length){
            if(sum==target)record[0]++;
            return;
        }
        backtrack(record, nums, start+1, sum+nums[start], target);
        backtrack(record, nums, start+1, sum-nums[start], target);
    }
}
// @lc code=end


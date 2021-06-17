/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
/**
 * 左右遍历
 * 子数组的两边肯定是有序的，并且左边最大值小于子数组最小值，右边最小值大于子数组最大值
 * 1、从右到左遍历，维护一个最小值，如果当前值比最小值大，说明当前值要移动到最小值的后面，当前值就不是子数组的左边界，左边界左边的数都
 * 会小于最小值的
 * 2、从左到右遍历，维护一个最大值，当前值比最大值小，则该值肯定要移动到最大值的前面，所以不是子数组右边界，有边界右边的数都大于最大值的
 * 
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int right = -1;
        int max = Integer.MIN_VALUE;
        int i=0;
        while(i<nums.length){
            if(nums[i]<max){
                right=i;
            }
            max = Math.max(max, nums[i++]);
        }
        if(right==-1){
            return 0;
        }
        int left = -1;
        int min = Integer.MAX_VALUE;
        i=nums.length-1;
        while(i>=0){
            if(nums[i]>min){
               left=i;
            }
            min = Math.min(min, nums[i--]);
        }

        return right-left+1;
    }
}
// @lc code=end


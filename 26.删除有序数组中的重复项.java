/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while(right<nums.length){
            if(nums[right]!=nums[left]){
                left++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
        return left+1;
    }
}
// @lc code=end


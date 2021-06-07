
/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
// 时间复杂度要求只能使用二分搜索，才能达到时间复杂度O(log n)
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid= (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[start]<=nums[mid]){
                // 说明mid在最大值的左边一侧
                if(target>=nums[start]&&target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                // 说明mid在最大值的右边一侧
                if(target>nums[mid]&&target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;

    }
    
}
// @lc code=end


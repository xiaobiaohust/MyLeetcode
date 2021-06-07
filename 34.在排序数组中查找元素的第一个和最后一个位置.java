/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                index = mid;
                break;
            }
            if(target<nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if(index==-1){
            return new int[]{-1,-1};
        }
        for(int i=index;i>-1;--i){
            if(nums[index]!=nums[i]){
                break;
            }
            start = i;
        }
        for(int i=index;i<nums.length;++i){
            if(nums[index]!=nums[i]){
                break;
            }
            end = i;
        }
        return new int[]{start,end};

    }
}
// @lc code=end


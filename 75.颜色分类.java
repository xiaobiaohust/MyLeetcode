/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
/**
 * 快排中的partition
 */
class Solution {
    public void sortColors(int[] nums) {
        int low = -1;
        int high = nums.length;
        int cur=0;
        while(cur<high){
            if(nums[cur]==0){
                int temp = nums[++low];
                nums[low] = nums[cur];
                nums[cur] = temp;
                cur++;
            }else if(nums[cur]==1){
                cur++;
            }else{
                int temp = nums[--high];
                nums[high] = nums[cur];
                nums[cur] = temp;
            }
        }

    }
}
// @lc code=end


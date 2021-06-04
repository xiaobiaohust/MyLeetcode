/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
/**
 * 双指针
 * 使用左右指针夹住中间区域，最多的水和最低的height有关
 * 假设水有底和高决定，底从大到小，移动左右指针，每次移动指针所在位置小的指针，因为我们需要得到可能更大的数，而一旦移动
 * 数量大的指针，高度一样，宽度变小了，不可能得到更大的面积
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
// @lc code=end


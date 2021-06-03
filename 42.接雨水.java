/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
/**
 * 思路：
 * 对于每个柱子，求出左边第一个比它大的柱子，右边第一个比它大的柱子，两者缺一则无法
 * 接水，左右宽度为存水的宽度，高度为左右柱子较小的一个，所代表的的矩形在减去矩形当中的柱子
 * 就是真实的存储水量
 * 1、使用两个map，分布从左至右、从右至左得到每个数zui
 */
class Solution {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int len = height.length;

        int[] left  = new int[len];
        left[0] = height[0];
        for(int i=1;i<len;++i){
            left[i] = Math.max(left[i-1], height[i]);
        }

        int[]right = new int[len];
        right[len-1] =height[len-1]; 
        for(int i=len-2;i>=0;--i){
            right[i] = Math.max(right[i+1], height[i]);
        }
        int ans = 0;
        for(int i=0;i<len;++i){
            ans+=Math.min(left[i], right[i])-height[i];
        }
        return ans;
    }
}
// @lc code=end


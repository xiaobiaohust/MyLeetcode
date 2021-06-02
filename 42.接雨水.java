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

    }
}
// @lc code=end


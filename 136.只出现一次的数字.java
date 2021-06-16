/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
/**
 * 位运算
 * 利用^异或运算的特性
 * 1、任何数和0异或，都是原数
 * 2、任何数和自己异或都是0
 * 3、异或运算满足交换律结合律
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num:nums){
            res ^=num;
        }
        return res;
    }
}
// @lc code=end


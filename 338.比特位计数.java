/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
/**
 * 思想一、对每个数进行异或和右移操作，类似斐波拉契数列
 * f(i) = f(i/2)+i%2
 */
class Solution {
    public int[] countBits(int n) {
        int[]nums = new int[n+1];
        for(int i=1;i<n+1;++i){
            nums[i] = nums[i>>1]+(i&1);
        }
        return nums;

    }
}
// @lc code=end


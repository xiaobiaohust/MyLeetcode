import javax.smartcardio.ATR;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minlen = Integer.MAX_VALUE;
        int sum = 0;
        while(right<nums.length){
            sum+=nums[right];
            if(sum>=target){
                while(sum-nums[left]>=target){
                    sum-=nums[left++];
                }
                minlen = Math.min(minlen, right-left+1);
                sum-=nums[left++];
            }
            right++;
        }
        return minlen==Integer.MAX_VALUE?0:minlen;

    }
}
// @lc code=end


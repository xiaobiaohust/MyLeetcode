import java.util.function.IntFunction;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int candidate = nums[0];
        int times = 1;
        for(int i=1;i<nums.length;++i){
            if(times==0){
                candidate = nums[i];
                times = 1;
            }else if(candidate==nums[i]){
                times++;
            }else{
                times--;
            }
        }
        return candidate;
    }
}
// @lc code=end


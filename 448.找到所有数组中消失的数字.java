import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>res = new ArrayList<>();
        for(int i=0;i<nums.length;++i){
            int cur = nums[i];
            while(cur!=i+1&&cur!=nums[cur-1]){
                int temp  = nums[cur-1];
                nums[cur-1] = cur;
                nums[i] = temp;
                cur = temp;
            }
        }
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=i+1){
                res.add(i+1);
            }
        }
        return res;
    }
}
// @lc code=end


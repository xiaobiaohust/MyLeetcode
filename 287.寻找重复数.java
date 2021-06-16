/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
/**思想一、
 * n+1个数，取值范围为1~n，可以把每个元素放在其对应的位置上，遍历一遍就可以找出，时间复杂度O(N)，空间复杂度O(1)，但是会改变数组
 * 
 * 思想二、快慢指针
 * 类似环形链表，每个节点有其下一个节点；数组中每个元素都去找他正确放置的位置,i放置在nums[i]
 * 如果没有重复元素,每个元素都可以找到其对应的正确位置，类似链表一样串起来，如果有重复的元素，则会出现
 * 环，可以使用环形链表类似的算法求出入环的位置，就是target
 */
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        slow= nums[slow];
        fast = nums[nums[fast]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// @lc code=end


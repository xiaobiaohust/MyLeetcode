import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
/**
 * 最小堆
 * 最小堆总是是最大的k个数
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>queue = new PriorityQueue<>();
        int i=0;
        while(i<nums.length){
            if(queue.size()<k){
                queue.offer(nums[i]);
            }else if(queue.peek()<nums[i]){
                queue.poll();
                queue.add(nums[i]);
            }
            ++i;
        }
        return queue.peek();
    }
}
// @lc code=end


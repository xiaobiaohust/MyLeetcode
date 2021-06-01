import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        LinkedList<Integer> q = new LinkedList<Integer>();
        int cur = 0;
        int index = 0;
        while(cur<nums.length){
            while(!q.isEmpty()&&nums[q.peekLast()]<=nums[cur]){
                q.pollLast();
            }
            q.offerLast(cur);
            if(cur-q.peekFirst()>=k){
                q.pollFirst();
            }
            if(cur>=k-1){
                res[index++] = nums[q.peekFirst()];
            }
            cur++;
        }
        return res;
    }
}
// @lc code=end


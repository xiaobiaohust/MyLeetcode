import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
/**
 * 单调栈.从底到顶单调递增
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==1){
            return heights[0];
        }
        Stack<Integer>stack= new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int cur = 0;
        while(cur<heights.length){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[cur]){
                int i = stack.pop();
                int j = stack.isEmpty()?-1:stack.peek();
                maxArea = Math.max(maxArea, (cur-j-1)*heights[i]);
            }
            stack.push(cur);
            cur++;
        }
        while(!stack.isEmpty()){
            int i = stack.pop();
            int j = stack.isEmpty()?-1:stack.peek();
            maxArea = Math.max(maxArea, (heights.length-1-j)*heights[i]);
        }
        return maxArea;
    }
}
// @lc code=end


import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
/**
 * 思想：
 * 其实就是求每个数右边第一个比他大的数，和求直方图的面积有点类似，直方图需要求左右比他小的位置
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==1){
            return new int[1];
        }
        int []res = new int[temperatures.length];
        Stack<Integer>stack = new Stack<>();
        for(int i=0;i<temperatures.length;++i){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int index = stack.pop();
                res[index] = i-index;
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end


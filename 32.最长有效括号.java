import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxlen = 0;
        int left =-1;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    left = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        maxlen = Math.max(maxlen, i-left);
                    }else{
                        maxlen = Math.max(maxlen,i-stack.peek());
                    }
                }
            }
        }
        return maxlen;

    }
}
// @lc code=end


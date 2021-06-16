import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
/**
 * 类似括号的有效性，求中括号的有效性
 */
class Solution {
    public String decodeString(String s) {
        Stack<String>stack = new Stack<>();
        Stack<String>help = new Stack<>();
        for(int i=0;i<s.length();++i){
            if(!s.substring(i, i+1).equals("]")){
                stack.push(s.substring(i, i+1));
            }else{
                StringBuilder str = new StringBuilder();
                while(!stack.peek().equals("[")){
                    help.push(stack.pop());
                }
                while(!help.isEmpty()){
                    str.append(help.pop());
                }
                stack.pop();

                StringBuilder nums = new StringBuilder();
                while(!stack.isEmpty()&&stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9'){
                    nums.append(stack.pop());
                }
                nums.reverse();

                StringBuilder item = new StringBuilder();
                for(int j=0;j<Integer.valueOf(nums.toString());++j){
                    item.append(str);
                }
                stack.push(item.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            help.push(stack.pop());
        }
        while(!help.isEmpty()){
            res.append(help.pop());
        }
        return res.toString();
    }
}
// @lc code=end


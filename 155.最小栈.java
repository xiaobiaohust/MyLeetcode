import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    private Stack<Integer>stack;
    private Stack<Integer>minStack ;

    /** initialize your data structure here. */
    public MinStack() {
        stack  = new Stack<>();
        minStack = new Stack<>();

    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.size()==0||val<=minStack.peek()){
            minStack.push(val);
        }

    }
    
    public void pop() {
        int temp = stack.pop();
        if(temp==minStack.peek()){
            minStack.pop();
        }


    }
    
    public int top() {
        return stack.peek();

    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end


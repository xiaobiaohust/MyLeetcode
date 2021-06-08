import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        int []heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                heights[j]= matrix[i][j]=='0'?0:heights[j]+1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));

        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights) {
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


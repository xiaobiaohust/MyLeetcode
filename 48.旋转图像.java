/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length==1){
            return;
        }
        int row_0 = 0;
        int col_0 = 0;
        int row_1 = matrix.length-1;
        int col_1 = matrix[0].length-1;
        while(row_0<row_1){
            process(matrix,row_0++,col_0++,row_1--,col_1--);
        }
    }
    private void process(int[][] matrix,int row_0,int col_0,int row_1,int col_1){
        for(int i=0;i<col_1-col_0;++i){
            int temp= matrix[row_0][col_0+i];
            matrix[row_0][col_0+i]= matrix[row_1-i][col_0];
            matrix[row_1-i][col_0] = matrix[row_1][col_1-i];
            matrix[row_1][col_1-i] = matrix[row_0+i][col_1];
            matrix[row_0+i][col_1]= temp;
        }
    }
}
// @lc code=end


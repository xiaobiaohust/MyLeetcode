/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i= 0;
        int j = matrix[0].length-1;
        while(i<matrix.length&&j>-1){
            if(matrix[i][j]==target){
                return true;
            }else if(target>matrix[i][j]){
                i++;
            }else{
                j--;
            }

        }
        return false;
        
    }
}
// @lc code=end


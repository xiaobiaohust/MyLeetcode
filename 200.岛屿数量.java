/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * DFS
 * 深度优先遍历
 */
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int nums = 0;
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                if(grid[i][j]=='1'){
                    process(grid,i,j);
                    nums++;

                }
            }
        }
        return nums;

    }
    private void process(char[][]grid,int i,int j){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]!='1'){
            return;
        }
        grid[i][j] = 'a';
        process(grid, i-1, j);
        process(grid, i+1, j);
        process(grid, i, j-1);
        process(grid, i, j+1);
    }
}
// @lc code=end


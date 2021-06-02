/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;++i){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][col-1]==1) dfs(grid,i,col-1);
        }
        for(int j=1;j<col-1;++j){
            if(grid[0][j]==1) dfs(grid,0,j);
            if(grid[row-1][j]==1) dfs(grid, row-1, j);
        }
        int res=0;
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                if(grid[i][j]==1)res++;
            }
        }
        return res;

    }
    private void dfs(int[][]grid,int i,int j){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]==0||grid[i][j]==-1){
            return;
        }
        grid[i][j]=-1;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
// @lc code=end


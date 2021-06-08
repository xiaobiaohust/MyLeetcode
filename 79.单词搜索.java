import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
/**
 * 可以使用暴力搜索，网格和字符串的首字母相同，则进行搜索，只是这个搜索，可以使用回溯法
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(search(board,i,j,word,0,new boolean[board.length][board[0].length])){
                    return  true;
                }
            }
        }
        return false;

    }
    private boolean search(char[][]A, int i, int j, String word, int start, boolean[][]visited){
        if(start==word.length()){
            return true;
        }
        if(i<0||i>A.length-1||j<0||j>A[0].length-1||A[i][j]!=word.charAt(start)||visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        // 打平的回溯法
        if(search(A, i-1, j, word, start+1,visited)||search(A, i+1, j, word, start+1,visited)||
        search(A, i, j-1, word, start+1,visited)||search(A, i, j+1, word, start+1,visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
// @lc code=end


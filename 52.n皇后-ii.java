

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {

        int[] record = new int[n];
        return process(record, n, 0);
    }

    // 使用递归解决
    private int process(int[] record,int n,int i){
        if(i==n){
            return 1;
        }
        int res = 0;
        for(int j=0;j<n;++j){
            if(isValid(record,i,j)){
                record[i] = j;
               res+= process(record, n, i+1);
            }
        }
        return res;
    }
    private boolean isValid(int[]record,int i,int j){
        for(int k=0;k<i;++k){
            if(record[k]==j||Math.abs(i-k)==Math.abs(record[k]-j)){
    
                return false;
            }
        }
        return true;
    }
}
// @lc code=end


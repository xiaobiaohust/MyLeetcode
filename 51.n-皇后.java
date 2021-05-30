import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[]record = new int[n];
        List<List<String>> list = new ArrayList<>();
        process(list,new ArrayList<>(),record, n, 0);
        return list;

    }
      // 使用递归解决
      private void process(List<List<String>> list,List<String>tempList,int[] record,int n,int i){
        if(tempList.size()==n){
            list.add(new ArrayList<>(tempList));
            return ;
        }
        for(int j=0;j<n;++j){
            if(isValid(record,i,j)){
                record[i] = j;
                tempList.add(formatData(n,j));
                process(list,tempList,record, n, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    private boolean isValid(int[]record,int i,int j){
        for(int k=0;k<i;++k){
            if(record[k]==j||Math.abs(i-k)==Math.abs(record[k]-j)){
    
                return false;
            }
        }
        return true;
    }
    private String formatData(int n,int j){
        char[]row= new char[n];
        Arrays.fill(row, '.');
        row[j] = 'Q';
        return String.valueOf(row);
    }
}
// @lc code=end


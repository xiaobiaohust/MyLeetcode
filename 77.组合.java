import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),n,k,1);
        return list;
    }
    private void backtrack(List<List<Integer>>list,List<Integer>tempList,int n,int k,int start){
        if(tempList.size()==k){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start;i<n+1;++i){
            tempList.add(i);
            backtrack(list, tempList, n, k, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
// @lc code=end


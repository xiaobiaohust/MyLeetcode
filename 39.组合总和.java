import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;

    }
    public void backtrack(List<List<Integer>>list,List<Integer>tempList,int[] candidates,int remain,int start){
        if(remain<0){
            return;
        }
        if(remain==0){
            list.add(new ArrayList<>(tempList));
        }
        for(int i=start;i<candidates.length;++i){
            tempList.add(candidates[i]);
            backtrack(list, tempList, candidates, remain-candidates[i], i);
            tempList.remove(tempList.size()-1);
           
        }
    }
}
// @lc code=end


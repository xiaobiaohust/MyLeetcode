import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>>list,List<Integer>tempList,int[]nums,boolean[]used){
        if(tempList.size()==nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;++i){
            //含有重复元素的排列，首先需要对数组进行排序；
            //在某个位置，相同的元素在这个地方，就会产生重复数据，只需跳过去
            // 但是不同的位置，相同元素则没关系
            if(used[i] ||i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,used);
            tempList.remove(tempList.size()-1);
            used[i] = false;
        }
    }
}
// @lc code=end


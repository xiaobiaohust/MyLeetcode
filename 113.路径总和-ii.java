import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>list = new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer>tempList = new ArrayList<>();
        tempList.add(root.val);
        backtrack(list,tempList,root,targetSum);
        return list;
    }
    private void backtrack(List<List<Integer>>list,List<Integer>tempList,TreeNode root,int targetSum){
        if(root==null){
            return;
        }
        
        if(root.left==null&&root.right==null){
            if(root.val==targetSum){
                list.add(new ArrayList<>(tempList));
            }
            return;
        }
        if(root.left!=null){
            tempList.add(root.left.val);
            backtrack(list, tempList, root.left, targetSum-root.val);
            tempList.remove(tempList.size()-1);
        }
        if(root.right!=null){
            tempList.add(root.right.val);
            backtrack(list, tempList, root.right, targetSum-root.val);
            tempList.remove(tempList.size()-1);
        }
    }
}
// @lc code=end


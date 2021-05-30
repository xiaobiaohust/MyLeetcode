/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            if(targetSum==root.val){
                return true;
            }else{
                return false;
            }
        }
        boolean flag = false;
        if(root.left!=null){
            flag = hasPathSum(root.left, targetSum-root.val);
        }
    
        if(flag==true){
            return flag;
        }
        if(root.right!=null){
            flag = hasPathSum(root.right, targetSum-root.val);

        }
        return flag;
    }
}
// @lc code=end


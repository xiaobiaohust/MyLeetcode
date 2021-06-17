/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
/**
 * 使用两个不同的递归解决
 * 1、第一个递归，给出跟节点，target，返回路径总数，可包含跟节点
 * 2、第一个递归，给出跟节点，target，返回路径总数，必须包含跟节点
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int sum=0;
        sum+= pathSum(root.left, targetSum);
        sum+= pathSum(root.right, targetSum);
        sum+= pathSum1(root, targetSum);
        return sum;
    }
    int pathSum1(TreeNode root,int targetSum){
        if(root==null){
            return 0;
        }
        int sum = 0;
        targetSum-=root.val;
        if(targetSum==0){
            sum+=1;
        }
        sum+= pathSum1(root.left, targetSum);
        sum+= pathSum1(root.right, targetSum);
        return sum;
    }
}
// @lc code=end


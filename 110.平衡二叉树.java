/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int []record = new int[1];
        return isBalenced1(root,record);

    }
    private boolean isBalenced1(TreeNode root,int []record){
        if(root==null){
            record[0] =0;
            return true;
        }
        boolean flag = isBalenced1(root.left, record);
        if(!flag) return false;
        int maxDepth_L = record[0];

        flag = isBalenced1(root.right, record);
        if(!flag) return false;
        int maxDepth_R = record[0];
        if(Math.abs(maxDepth_L-maxDepth_R)>1) return false;
        record[0] = Math.max(maxDepth_L, maxDepth_R)+1;
        return true;
    }
}
// @lc code=end


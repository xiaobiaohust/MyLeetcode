/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
 * 二叉树的遍历
 * 1、假设直径过根节点，求出左右子树的最大高度，即可求出
 * 2、假设直径不过根节点，则最大值为左子树右子树中的最大的一个
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[]record = new int[1];
        return process(root, record)-1;

    }
    private int process(TreeNode root,int[]record){
        if(root==null){
            record[0] = 0;
            return 0;
        }
        int leftmax = process(root.left, record);
        int leftHeight = record[0];
        int rightmax = process(root.right, record);
        int rightHeight = record[0];
        int res = Math.max(leftmax, rightmax);
        res = Math.max(res, leftHeight+rightHeight+1);
        record[0] = Math.max(leftHeight, rightHeight)+1;
        return res;
    }
}
// @lc code=end


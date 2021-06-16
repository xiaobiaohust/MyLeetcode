import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
 * 二叉树的递归遍历
 * 
 */
class Solution {
    // 太多的递归，时间过不了，需要优化一下
    // public int rob(TreeNode root) {
    //     if(root==null){
    //         return 0;
    //     }

    //     int Profit1 = 0;
    //     Profit1+=rob(root.left);
    //     Profit1+=rob(root.right);

    //     int profit2 = root.val;
    //     if(root.left!=null){
    //         profit2+=rob(root.left.left);
    //         profit2+=rob(root.left.right);
    //     }
    //     if(root.right!=null){
    //         profit2+=rob(root.right.left);
    //         profit2+=rob(root.right.right);
    //     }
    //     return Math.max(Profit1, profit2);

    // }
    public int rob(TreeNode root){
        int[]res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    //返回一个数组，res[0]表示包含跟节点的最大值，res[1]表示不包含跟节点的最大值
    private int[]dfs(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int[]left = dfs(root.left);
        int[]right = dfs(root.right);
        int[]res = new int[2];
        res[0] = root.val+left[1]+right[1];
        res[1] = Math.max(left[0], left[1])+Math.max(right[0], right[1]);
        return res;
    }
}
// @lc code=end


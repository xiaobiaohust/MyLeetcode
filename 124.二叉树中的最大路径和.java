import java.util.Stack;


/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
 * 递归
 * 该问题和最大数组的累加和问题不一样，由于对路径的定义不一样
 * 可以认为每个路径都有一个其根节点，从跟节点向左右子树两边扩展
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] record= new int[1];
        record[0] = Integer.MIN_VALUE;
        maxGain(root,record);
        return record[0];
       
    }
    // 该函数表示从root开始，在root为根节点的子树中，寻找一条和最大的路径，返回最大和
    // 通过递归实现该函数，在得到左子树、右子树的最大和的时候，顺便可以得到以该节点为跟节点的最大路径
    private int maxGain(TreeNode root,int[] record){
        if(root ==null ){
            return 0;
        }
        int leftGain =Math.max(maxGain(root.left,record), 0);
        int rightGain = Math.max(maxGain(root.right,record), 0);
        record[0] = Math.max(record[0], root.val+leftGain+rightGain);
        return Math.max(leftGain, rightGain)+root.val;
    }
}
// @lc code=end


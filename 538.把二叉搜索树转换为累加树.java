/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
 * 使用二叉树的遍历，先右子树、在跟节点，最后左子树
 * 1、对跟节点的右子树转换为新的累加树，需要返回新的累加树的跟节点，同时使用record记录子树的所有
 * 元素的和
 * 2、对跟节点的左子树同样转化为新的累加树，只不过左子树的所有节点都有个初始值，该初始值为右子树
 * 的所有节点和，在加上跟节点的值，作为初始值
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int[]record = new int[1];
        return process(root, record, 0);

    }
    // record[0]表示root跟节点对应子树的和，record[1]表示传入子树的初始值
    private TreeNode process(TreeNode root,int[]record,int initvalue){
        if(root==null){
            record[0] = 0;
            return null;
        }
        int sum = root.val;
        TreeNode right = process(root.right, record, initvalue);
        sum+=record[0];
        TreeNode newHead = new TreeNode(sum+initvalue);
        TreeNode left = process(root.left, record, newHead.val);
        sum+=record[0];
        newHead.left = left;
        newHead.right = right;
        record[0] = sum;
        return newHead;
    }
}
// @lc code=end


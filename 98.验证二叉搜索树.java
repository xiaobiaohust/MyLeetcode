import java.time.Year;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
 * 方法一、每个节点从根节点开始往下走，能走到自己的位置，说明是搜素二叉树
 * 方法二、搜素二叉树的中序排序是递增的
 */
class Solution {
    public boolean isValidBST(TreeNode root){
        if(root==null){
            return true;
        }
        Stack<TreeNode>stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre!=null&&pre.val>=cur.val) return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }

    // public boolean isValidBST(TreeNode root) {
    //     if(root==null){
    //         return true;
    //     }

    //     return isBST(root,root);

    // }
    // private boolean isBST(TreeNode root,TreeNode node){
    //     if(node==null){
    //        return true;
    //     }
    //      return isInBST(root,node)&&isBST(root, node.left)&&isBST(root, node.right);
    // }
    // private boolean isInBST(TreeNode root,TreeNode node){
    //     TreeNode cur = root;
    //     while(cur!=null){
    //         if(cur==node){
    //             return true;
    //         }else if(cur.val>node.val){
    //             cur=cur.left;
    //         }else if(cur.val<node.val){
    //             cur = cur.right;
    //         }else{
    //             return false;
    //         }
    //     }
    //     return false;
    // }
}
// @lc code=end


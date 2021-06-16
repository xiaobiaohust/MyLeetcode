import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
 * 利用二叉树的先序遍历的序列化
 * 利用和先序遍历相反的遍历的序列化，先跟节点，在右子树，左子树
 * fe
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
       
        return preOrder(root).equals(inOrder(root));

    }
    private String preOrder(TreeNode root){
        String res = "";
        if(root==null){
            res+="#_";
            return res;
        }
        res+=root.val+"_";
        res+=preOrder(root.left);
        res+=preOrder(root.right);
        return res;
    }
    private String inOrder(TreeNode root){
        String res = "";
        if(root==null){
            res+="#_";
            return res;
        }
        res+=root.val+"_";
        res+=inOrder(root.right);
        res+=inOrder(root.left);
        return res;
    }
}
// @lc code=end


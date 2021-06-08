import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return gennerate(1,n);

    }
    private List<TreeNode> gennerate(int start,int end){
        List<TreeNode>res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;++i){
            List<TreeNode>L = gennerate(start, i-1);
            List<TreeNode>R = gennerate(i+1, end);
            for(TreeNode nodeL:L){
                for(TreeNode nodeR:R){
                    TreeNode head = new TreeNode(i);
                    head.left = nodeL;
                    head.right = nodeR;
                    res.add(head);
                }
            }
        }
        return res;

    }
}
// @lc code=end


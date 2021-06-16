import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur =null;
        TreeNode last = root;
        TreeNode nextLast = null;

        while(!queue.isEmpty()){
            cur = queue.poll();
            list.add(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
                nextLast = cur.left;
            }
            if(cur.right!=null){
                queue.offer(cur.right);
                nextLast = cur.right;
            }
            if(cur==last){
                res.add(list);
                list = new ArrayList<>();
                last = nextLast;
            }
        }
        return res;
    }
}
// @lc code=end


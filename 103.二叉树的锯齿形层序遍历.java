import java.lang.invoke.ClassSpecializer.Factory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        LinkedList <TreeNode>queue = new LinkedList<>();
        queue.offerLast(root);
        TreeNode cur = null;
        TreeNode last = root;
        TreeNode nextLast = null;
        boolean flag= true;
        while(!queue.isEmpty()){
            if(flag){
                cur = queue.pollFirst();
                list.add(cur.val);
                if(cur.left!=null){
                    queue.offerLast(cur.left);
                    nextLast = nextLast==null?cur.left:nextLast;
                }
                if(cur.right!=null){
                    queue.offerLast(cur.right);
                    nextLast = nextLast==null?cur.right:nextLast;
                }
                if(cur==last){
                    res.add(list);
                    list = new ArrayList<>();
                    last = nextLast;
                    nextLast=null;
                    flag=!flag;
                }
            }else{
                cur = queue.pollLast();
                list.add(cur.val);
                if(cur.right!=null){
                    queue.offerFirst(cur.right);
                    nextLast = nextLast==null?cur.right:nextLast;
                }
                if(cur.left!=null){
                    queue.offerFirst(cur.left);
                    nextLast = nextLast==null?cur.left:nextLast;
                }
                if(cur==last){
                    res.add(list);
                    list = new ArrayList<>();
                    last = nextLast;
                    nextLast=null;
                    flag = !flag;
                }
            }
        }
        return res;
    }
}
// @lc code=end


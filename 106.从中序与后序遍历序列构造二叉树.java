/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder.length==0){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;++i){
            map.put(inorder[i], i);
        }
        return buildTreeUncur(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);

    }
    private TreeNode buildTreeUncur(int []postorder,int start_0,int end_0,int[]inorder,int start_1,int end_1,HashMap<Integer,Integer> map){
        if(start_0>end_0){
            return null;
        }
        
        TreeNode head = new TreeNode(postorder[end_0]);
        int mid = map.get(postorder[end_0]);
        int len_L = mid-start_1;
        int len_R = end_1-mid;
        head.left = buildTreeUncur(postorder, start_0, start_0+len_L-1, inorder, start_1, mid-1, map);
        head.right = buildTreeUncur(postorder, end_0-len_R, end_0-1, inorder, mid+1, end_1, map);
        return head;

    }
}
// @lc code=end


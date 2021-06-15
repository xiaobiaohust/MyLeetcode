import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 后序遍历
 * 思想：访问跟节点，跟节点含有其中一个值，则直接返回跟节点，看左右子树是否含有节点
 * 1、左右子树都含有，则返回跟节点
 * 2、左右子树只有一个含有，则继续访问子树
 * 3、左右子树都不含有，则不存在
 * 上述s思想，可以采取后序遍历，访问左子树，访问右子树，在进行合并。两个节点可能在一条链路上，也可能在不同
 * 的分支上，在一个链路上的时候，遇到一个节点就返回，在不同分支上，则可以进行合并
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.val==p.val||root.val==q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;
    
    }
}
// @lc code=end


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#_";
        }
        String res = String.valueOf(root.val)+"_";
        res+=serialize(root.left);
        res+= serialize(root.right);
        return res;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]arr = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for(String str:arr){
            queue.offer(str);
        }
       return  process(queue);
        
    }
    private TreeNode process(Queue<String>queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = process(queue);
        head.right = process(queue);
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end


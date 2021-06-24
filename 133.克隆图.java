import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;

import jdk.internal.org.objectweb.asm.Handle;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/**
 * 方法一：递归
 * 对于每个节点，递归函数返回其对应的clone节点
 * 生成跟节点的clone，对于每个邻居节点，生成其对应的clone图，使用map记录已clone的节点
 * 
 * 
 * 方法二：使用队列遍历
 * 使用map记录原节点和克隆节点的映射关系
 * 使用队列clone每一个元素
 * 
 * 
 */
class Solution {
    private HashMap<Node,Node>map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return process(node);
    }

    public Node process(Node node){
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        for(Node temp:node.neighbors){
            cloneNode.neighbors.add(process(temp));
        }
        return cloneNode;
    }

    // public Node cloneGraph(Node node) {
    //     if(node==null) return null;
    //     Node newHead=null;
    //     HashMap<Node,Node>map = new HashMap<>();
    //     LinkedList<Node>queue = new LinkedList<>();
    //     HashSet<Node>set = new HashSet<>();
    //     queue.offerLast(node);
    //     set.add(node);
    //     while(!queue.isEmpty()){
    //         Node cur =  queue.pollFirst();
    //         List<Node>neighbors = new ArrayList<>();
    //         for(Node temp:cur.neighbors){
    //             if(!set.contains(temp)){
    //                 queue.offerLast(temp);
    //                 set.add(temp);
    //             }
    //             if(map.containsKey(temp)){
    //                 neighbors.add(map.get(temp));
    //             }else{
    //                 Node temp1 = new Node(temp.val);
    //                 map.put(temp, temp1);
    //                 neighbors.add(temp1);
    //             }
    //         }
    //         Node newNode;
    //         if(map.containsKey(cur)){
    //             newNode = map.get(cur);
    //         }else{
    //             newNode = new Node(cur.val);
    //             map.put(cur, newNode);
    //         }
    //         newNode.neighbors= neighbors;
    //         if(cur==node){
    //             newHead =newNode;
    //         }
    //     }
    //     return newHead;
    // }
}
// @lc code=end


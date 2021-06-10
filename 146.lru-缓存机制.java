import java.util.HashMap;
import java.util.LinkedHashMap;

import org.graalvm.compiler.lir.aarch64.AArch64Move.Move;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
/**
 * 方法一：使用java自带的LinkedHashMap实现
 * 方法二：使用哈希表+双向链表实现
 */
// class LRUCache extends LinkedHashMap<Integer, Integer>{
//     private int capacity;
    
//     public LRUCache(int capacity) {
//         super(capacity, 0.75F, true);
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }

//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity; 
//     }
// }


class LRUCache{
    class Node{
        public int key;
        public int value;
        public  Node pre;
        public Node next;
        public Node(){};
        public Node(int key,int value){
            this.key = key;
            this.value = value;

        }
    }
    private int capacity;
    private HashMap<Integer,Node> map;
    private Node head ;
    private Node tail;
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node cur = map.get(key);
        moveToHead(cur);
        return cur.value;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.value = value;
            moveToHead(cur);
        }else{
            Node cur = new Node(key,value);
            map.put(key, cur);
            addToHead(cur);
        }
        if(map.size()>capacity){
            map.remove(tail.pre.key);
            moveTail();
        }
    }

    public void moveToHead(Node cur){
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        addToHead(cur);
    }
    public void addToHead(Node cur){
        cur.pre = head;
        cur.next = head.next;
        head.next = cur;
        cur.next.pre = cur;
    }
    public void moveTail(){
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end


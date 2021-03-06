
/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(int i=0;i<word.length();++i){
            int index = word.charAt(i)-'a';
            if(cur.map[index]==null){
                cur.map[index] = new Node();
            }
            cur = cur.map[index];
        }
        cur.end++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(int i=0;i<word.length();++i){
            int index =word.charAt(i)-'a';
            if(cur.map[index]==null){
                return false;
            }
            cur = cur.map[index];
        }
        return cur.end==0?false:true;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i=0;i<prefix.length();++i){
            int index =prefix.charAt(i)-'a';
            if(cur.map[index]==null){
                return false;
            }
            cur = cur.map[index];
        }
        return true;
    }
}
class Node{
    int end;
    Node[]map;
    public Node(){
        end=0;
        map = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end


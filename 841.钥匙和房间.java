import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */
/**
 * 方法一、队列
 * 把能够得到的所有钥匙放在队列里，然后看最后
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        LinkedList<Integer>keys = new LinkedList<>();
        boolean []open = new boolean[len];
        keys.addAll(rooms.get(0));
        open[0] = true;
        while(!keys.isEmpty()){
            int key = keys.poll();
            if(!open[key]){
                keys.addAll(rooms.get(key));
                open[key] = true;
            }
        }
        for(int i=0;i<len;++i){
            if(!open[i]) return false;
        }
        return true;     
    }
}
// @lc code=end


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
/**
 * map+堆
 */
class Solution {
    private HashMap<Integer,Integer>map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for(int i=0;i<nums.length;++i){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i])+1);
        }
        PriorityQueue<Integer>queue =   new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                if(map.get(o1)<map.get(o2)){
                    return 1;
                }else if(map.get(o1)>map.get(o2)){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        for(int key:map.keySet()){
            queue.add(key);
        }
        int size = Math.min(queue.size(), k);
        int[]res = new int[size];
        for(int i=0;i<size;++i){
            res[i] = queue.poll();
        }
        return res;
    }
}
// @lc code=end


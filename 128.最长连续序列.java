import java.util.HashMap;


/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
/**
 * 哈希表
 * 使用哈希表存储每个值，然后进行合并,
 * 哈希表的key是序列的左右边界，value是序列的长度
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int maxlen = 1;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                if(map.containsKey(nums[i]-1)){
                    maxlen = Math.max(maxlen, merge(map,nums[i]-1,nums[i]));
                }
                if(map.containsKey(nums[i]+1)){
                    maxlen = Math.max(maxlen, merge(map,nums[i],nums[i]+1));
                }
            }
        }
        return maxlen;
    }
    private int merge(HashMap<Integer,Integer>map,int less,int more){
        int left = less-map.get(less)+1;
        int right = more+map.get(more)-1;
        int len = right-left+1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
// @lc code=end


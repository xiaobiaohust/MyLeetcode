import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     if(s.length()==0){
    //         return 0;
    //     }
    //     char[]ss = s.toCharArray();
    //     int maxlen = Integer.MIN_VALUE;
    //     int l=0;
    //     int r=0;
    //     HashSet<Character>set = new HashSet<>();
    //     while(r<ss.length){
    //         if(!set.contains(ss[r])){
    //             set.add(ss[r++]);
    //             maxlen = Math.max(maxlen, set.size());
    //         }else{
    //             set.remove(ss[l++]);
    //         }
    //     }
    //     return maxlen;
    // }
    public int lengthOfLongestSubstring(String s){
        if(s.length()==0){
            return 0;
        }
        char[]ss = s.toCharArray();
        int maxlen = Integer.MIN_VALUE;
        int l=0;
        int r=0;
        HashMap<Character,Integer>map = new HashMap<>();
        while(r<s.length()){
            if(!map.containsKey(ss[r])){
                map.put(ss[r], 0);
                maxlen = Math.max(maxlen, r-l+1);
                r++;
            }else{
                map.remove(ss[l++]);
            }
        }
        return maxlen;
    }
}
// @lc code=end


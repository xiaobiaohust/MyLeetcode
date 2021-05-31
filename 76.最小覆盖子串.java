/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        char[]ss = s.toCharArray();
        char[]tt = t.toCharArray();
        int[]map = new int[256];
        for(int i=0;i<tt.length;++i){
            map[tt[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = tt.length;
        int minlen = Integer.MAX_VALUE;
        int start = -1;
        while(right<ss.length){
            map[ss[right]]--;
            if(map[ss[right]]>=0){
                match--;
            }
            if(match==0){
                while(map[ss[left]]<0){
                    map[ss[left++]]++;
                }
                if(minlen>right-left+1){
                    minlen = right-left+1;
                    start = left;
                }
                map[ss[left++]]++;
                match++;
            }
            right++;
        }
        return start==-1?"":s.substring(start, start+minlen);

    }
}
// @lc code=end


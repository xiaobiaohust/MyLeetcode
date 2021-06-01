/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        char[]ss = s.toCharArray();
        int[]map = new int[26];
        int maxrepeat = 0;
        int maxlen = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while(right<ss.length){
            map[ss[right]-'A']++;
            maxrepeat = Math.max(maxrepeat, map[ss[right]-'A']);
            if(right-left+1<=k+maxrepeat){
                maxlen = Math.max(maxlen, right-left+1);
            }
            else{
                map[ss[left++]-'A']--;
            }
            right++;
        }
        return maxlen;
    }
}
// @lc code=end


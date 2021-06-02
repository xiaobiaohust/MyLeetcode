/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
/**
 * 题目要求的是子串，子串长度和s1一样
 * 方法一：
 *  和最小覆盖子串类似，只不过加了一个限制条件，那就是子串长度得和s1一样
 * 方法二、
 * 由于长度固定，可以使用长度固定的滑窗
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[]ch1 = s1.toCharArray();
        char[]ch2 = s2.toCharArray();
        int[]map = new int[26];
        for(int i=0;i<ch1.length;++i){
            map[ch1[i]-'a']++;
        }
        int match= ch1.length;
        int left=0;
        int right = 0;
        while(right<ch2.length){
            map[ch2[right]-'a']--;
            if(map[ch2[right]-'a']>=0){
                match--;
            }
            if(right-left+1==ch1.length){
                if(match==0){
                    return true;
                }
                map[ch2[left]-'a']++;
                if(map[ch2[left]-'a']>0){
                    match++;
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
// @lc code=end


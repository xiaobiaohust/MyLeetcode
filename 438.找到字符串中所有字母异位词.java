import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */
/**
 * 使用哈希表去统计字符串
 */
// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list = new ArrayList<>();
        char[]ss = s.toCharArray();
        char[]pp = p.toCharArray();
        int match = pp.length;
        int []map = new int[26];
        for(int i=0;i<pp.length;++i){
            map[pp[i]-'a']++;
        }
        int left = 0;
        int right = 0;
        while(right<ss.length){
            map[ss[right]-'a']--;
            if(map[ss[right]-'a']>=0){
                match--;
            }
            if(match==0){
                while(map[ss[left]-'a']<0){
                    map[ss[left++]-'a']++;
                }
                if(right-left+1==pp.length){
                    list.add(left);
                }
                map[ss[left++]-'a']++;
                match++;
            }
            right++;
        }
        return list;
    }
}
// @lc code=end


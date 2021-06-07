import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    // 对每个字符串进行排序，然后使用排序后的字符串作为key
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     if(strs==null||strs.length==0){
    //         return new ArrayList<>();
    //     }
    //     HashMap<String,List<String>> map = new HashMap<>();
    //     for(int i=0;i<strs.length;++i){
    //         char[]chs = strs[i].toCharArray();
    //         Arrays.sort(chs);
    //         String key = String.valueOf(chs);
    //         if(!map.containsKey(key)){
    //             map.put(key, new ArrayList<>());
    //         }
    //         map.get(key).add(strs[i]);
    //     }
    //     return new ArrayList<>(map.values());

    // }
    public List<List<String>>groupAnagrams(String[]strs){
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }
        HashMap<String,List<String>>map = new HashMap<>();
        for(int i=0;i<strs.length;++i){
            char []dic = new char[26];
            Arrays.fill(dic, 'A');
            for(int j=0;j<strs[i].length();++j){
                dic[strs[i].charAt(j)-'a']++;
            }
            String key = String.valueOf(dic);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());

    }
}
// @lc code=end


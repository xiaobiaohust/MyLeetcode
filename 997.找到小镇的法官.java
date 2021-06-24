import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
/**
 * 哈希表
 * 使用哈希表记录每个人有多少人相信他
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return n;
        }
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<n;++i){
            list.add(new ArrayList<>());
        }
        HashSet<Integer>notJudege = new HashSet<>();
        int maxlen = Integer.MIN_VALUE;
        for(int i=0;i<trust.length;++i){
            notJudege.add(trust[i][0]-1);
            list.get(trust[i][1]-1).add(trust[i][0]-1);
            if(list.get(trust[i][1]-1).size()>maxlen){
                maxlen = list.get(trust[i][1]-1).size();
            }
        }
        if(maxlen!=n-1){
            return -1;
        }
        for(int i=0;i<list.size();++i){
            if(list.get(i).size()==maxlen&& ! notJudege.contains(i)){
                return i+1;
            }
        }
        return -1;
    }
}
// @lc code=end


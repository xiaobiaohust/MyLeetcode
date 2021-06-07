import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
/**回溯法
 * 先求字符串的回文串dp,
 * 然后使用回溯法求解，dp用来判断子串是否是回文串
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>list = new ArrayList<>();
        // dp[i][j]表示s[i,j]子串是否是回文串
        boolean [][]dp = new boolean[s.length()][s.length()];
        for(int j=0;j<s.length();++j){
            for(int i=0;i<=j;++i){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        backtrack(list,new ArrayList<>(),dp,s,0);
        return list;
    }
    private void backtrack(List<List<String>>list,List<String>tempList,boolean[][]dp,String s,int start){
        if(start==s.length()){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start;i<s.length();++i){
            if(dp[start][i]){
                tempList.add(s.substring(start, i+1));
                backtrack(list, tempList, dp, s, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
// @lc code=end


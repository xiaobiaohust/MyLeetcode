import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
/**
 * 思路1：
 * 类似KMP算法，判断字典中的词是否是字符串的子串，找出所有的子串，可以得到所有子串的首末位置的一个数组，在将数组进行合并，
 * 这种思路解决不了
 * 思路2：
 * 回溯法。类似将字符串切割成回文串子串。回溯法太耗时，
 * 思路3：动态规划
 * 使用dp,dp[i]表示0~i-1的子串是能够由字典组成
 */
class Solution {
    // 动态规划
    public boolean wordBreak(String s,List<String>wordDict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length()+1 ;++i){
            for(int j=i-1;j>-1;--j){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }



    //回溯法
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     List<List<String>>list = new ArrayList<>();
        
    //     return backtrack(list,new ArrayList<>(),s,wordDict,0);
    // }
    // private boolean backtrack(List<List<String>>list,List<String>tempList,String s,List<String>wordDict,int start){
    //     if(start==s.length()){

    //         return true;
    //     }
    //     for(int i=start;i<s.length();++i){
    //         if(wordDict.contains(s.substring(start,i+1))){
    //             if(backtrack(list, tempList, s, wordDict, i+1))return true;
    //         }
    //     }
    //     return false;
    // }
}
// @lc code=end


import jdk.internal.agent.resources.agent_ja;

/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
/**
 * KMP解法
 * 1、将字符串s反转加在前面，可以组成一个回文串，添加的字符串长度len-1,所以添加的字符串
 * 应该小于等于len-1
 * 2、将字符串分为s1、s2两个子串，s1是回文串，s2和添加的字符符合回文串，也就是问题转化
 * 为求最长的回文前缀子串s1
 * 3、暴力解法求s1不满足时间要求，需要使用KMP算法
 * 4、KMP算法的nextArray可以求最长的公共前后缀，将s1反转加在s前面，求最长的公共
 * 前后缀长度，就可以得到s1
 * 5、KMP和判断是否是子串的KMP有一点点不一样，该题目的next数组长度会加1
 */
class Solution {
    public String shortestPalindrome(String s) {
      String s_reverse= new StringBuffer(s).reverse().toString();
      String s_all = s+"#"+s_reverse;
      int []next=new int[s_all.length()+1];
      next[0] = -1;
      next[1] =0;
      int i=2;
      int k = next[i-1];
      while(i<next.length){
        if(s_all.charAt(k)==s_all.charAt(i-1)){
            next[i++]=++k;
        }else if(k>0){
            k = next[k];
        }else{
            next[i++] = 0;
        }
    }
    String s1 = new StringBuffer(s.substring(next[s_all.length()])).reverse().toString();
    return s1+s;
    }
}
// @lc code=end


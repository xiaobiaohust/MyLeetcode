/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

 /**
  *  动态规划
  * 类似斐波那契数列
  f(n) = f(n-1)*f(0)+f(n-2)*f(1)+...+f(0)*f(n-1)
  */
// @lc code=start
class Solution {
    public int numTrees(int n) {
        int []res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i=2;i<n+1;++i){
            for(int j=i-1;j>-1;--j){
                res[i]+=res[j]*res[i-j-1];
            }
        }
        return res[n];
    }
}
// @lc code=end


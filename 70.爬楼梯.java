/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * 动态规划
 * 典型的斐波那契数列问题，f(n)=f(n-1)+f(n-2)
 */
class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int pre = 1;
        int prepre = 2;
        int cur = pre+prepre;
        for(int i=3;i<n;++i){
            pre = prepre;
            prepre = cur;
            cur = pre+prepre;
        }
        return cur;

    }
}
// @lc code=end


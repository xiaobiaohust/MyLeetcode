/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public  boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return process(s, e, 0, 0) ;
    }

    public  boolean process(char[] s, char[] e, int si, int ei) {
        // ei结束，看是否结束
        if (ei == e.length) {
            return si == s.length;
        }
        //e[ei+1]不为*
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (e[ei] == s[si] || e[ei] == '.') && process(s, e, si + 1, ei + 1);
        }
        //e[ei+1]为*,*从0次开匹配
        while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
            if (process(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        return process(s, e, si, ei + 2);
    }
}
// @lc code=end


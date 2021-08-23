/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
/**
 * 使用递归
 * '.'可以就看做一个元素，只是在比较相等的时候，这个是万能的
 * '*',一个元素后面有无'*',没有就按照正常处理，有的话需要循环遍历
 */
// class Solution {
//     public  boolean isMatch(String str, String exp) {
//         if (str == null || exp == null) {
//             return false;
//         }
//         char[] s = str.toCharArray();
//         char[] e = exp.toCharArray();
//         return process(s, e, 0, 0) ;
//     }
//     private boolean process(char[]s,char[]e,int si,int ei){
//         if(ei==e.length){
//             return si==s.length;
//         }
//         // e[ei+1] 不等于*的情况
//         if(ei+1==e.length||e[ei+1]!='*'){
//             return (si!=s.length)&&(s[si]==e[ei]||e[ei]=='.') && process(s, e, si+1, ei+1);
//         }
//         // e[ei+1] 等于*的情况,*可以匹配多次
//         while((si!=s.length)&&(s[si]==e[ei]||e[ei]=='.')){
//             if(process(s, e, si, ei+2)){
//                 return true;
//             }
//             si++;
//         }
//         // *没有匹配一次
//          return process(s, e, si, ei+2);
//     }

// }

/**
 * 动态规划
 * 递归会导致有很多重复的计算，可以考虑将递归转换为动态规划，递归函数入参变化的只有si、ei，可以使用二维的dp数组代替，并且
 * dp[i][j]的计算只依赖dp[i+1][j+1]、dp[i+k][j+2],所有可以从右到左，从下到上的计算dp,dp[0][0]则是最终所求
 */
class Solution{
    public boolean isMatch(String str,String exp){
        if(str==null||exp==null){
            return false;
        }
        char[]s = str.toCharArray();
        char[]e= exp.toCharArray();
        boolean[][]dp = initDp(s, e);
        for(int i=s.length-1;i>-1;--i){
            for(int j = e.length-2;j>-1;--j){
                if(e[j+1]!='*'){
                    dp[i][j] = (s[i]==e[j]||e[j]=='.')&&dp[i+1][j+1];
                }else{
                    int si = i;
                    while((si!=s.length)&&(s[si]==e[j]||e[j]=='.')){
                        if(dp[si][j+2]){
                            dp[i][j] = true;
                            break;
                        }
                        si++;
                    }
                    if(!dp[i][j]){
                        dp[i][j]=dp[si][j+2];
                    }
                }
            }
        }
        return dp[0][0];

    }
    //dp[i][j]表示str[i~len-1][j~len-1]，由于字符串可以是空串，所以dp的长宽需要+1，
    // 初始化是计算最下面一行，以及最左边两列
    private boolean[][] initDp(char[]s,char[]e){
        boolean[][]dp = new boolean[s.length+1][e.length+1];
        dp[s.length][e.length] = true;
        // 初始化最后一行，s剩下空串，而e剩下的元素不为空，则只能为重复“X*”，也就是e[i]='X'，e[i+1]='*'，一旦出现不是这样的，则之后的全部
        // 无法匹配
        for(int j=e.length-2;j>-1;j-=2){
            if(e[j]!='*'&&e[j+1]=='*'){
                dp[s.length][j] = true;
            }else 
                break;
        }
        if(s.length==0||e.length==0){
            return dp;
        }
        

        // 倒数第一列，由于e剩下空串，无法在匹配，所以除了最右下角的元素之外，其他的都是false
        // 倒数第二列，由于e剩下一个元素，如果剩下元素为’*‘,则无法匹配，不为’*‘,最多只能匹配一个元素，且是相等时才能匹配
        if(e[e.length-1]!='*'&&(e[e.length-1]==s[s.length-1]||e[e.length-1]=='.')){
            dp[s.length-1][e.length-1] = true;
        }
        
        return dp;
    }
}



// @lc code=end


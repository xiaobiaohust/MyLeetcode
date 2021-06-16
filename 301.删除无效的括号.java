import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        char[]ss = s.toCharArray();
        int leftRemove = 0;
        int rightRemove = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                leftRemove++;
            }else if(s.charAt(i)==')'){
                if(leftRemove>0){
                    leftRemove--;
                }else{
                    rightRemove++;
                }
            }
        }
        Set<String>res = new HashSet<>();
        backtrack(0,0,0,leftRemove,rightRemove,ss,res,new StringBuilder());
        return new ArrayList<>(res);
    }
    void backtrack(int index,int leftcounts,int rightcounts,int leftRemove,int rightRemove,char[]ss,Set<String>res,StringBuilder path){
        if(index==ss.length){
            if(leftRemove==0&&rightRemove==0){
                res.add(path.toString());
            }
            return;
        }
        // 首先考虑删除ss[index]元素
        if(ss[index]=='('){
            backtrack(index+1, leftcounts, rightcounts, leftRemove-1, rightRemove, ss, res, path);
        }else if(ss[index]==')'){
            backtrack(index+1, leftcounts, rightcounts, leftRemove, rightRemove-1, ss, res, path);
        }

        //考虑保留ss[index]元素
        path.append(ss[index]);
        if(ss[index]!='('&&ss[index]!=')'){
            // 非括号
            backtrack(index+1, leftcounts, rightcounts, leftRemove, rightRemove, ss, res, path);
        }else if(ss[index]=='('){
            //左括号
            backtrack(index+1, leftcounts+1, rightcounts, leftRemove, rightRemove, ss, res, path);
        }else if(leftcounts>rightcounts){
            //右括号
            backtrack(index+1, leftcounts, rightcounts+1, leftRemove, rightRemove, ss, res, path);
        }
        path.deleteCharAt(path.length()-1);
    }
}
// @lc code=end


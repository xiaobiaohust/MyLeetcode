import java.lang.invoke.ClassSpecializer.Factory;
import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack  = new Stack<>() ;
        char[]ss = s.toCharArray();
        HashMap<Character,Character> map  =new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        
        for(int i=0;i<ss.length;++i){
            if(ss[i]=='('||ss[i]=='['||ss[i]=='{'){
                stack.push(ss[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char temp = stack.pop();
                if(map.get(temp)!=ss[i]){
                    return false;
                }

            }
        }
        return stack.isEmpty()?true:false;

    }
}
// @lc code=end


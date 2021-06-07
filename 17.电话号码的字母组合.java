import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<>();
        }
        List<String>list = new ArrayList<>();
        char[]templist = new char[digits.length()];
        backtrack(list,templist,digits.toCharArray(),0);
        return list;
    }
    private void backtrack(List<String>list,char[]templist,char[]digits,int start){
        if(start==digits.length){
            list.add(String.valueOf(templist));
            return;
        }

        for(int i=0;i<(digits[start]=='7'||digits[start]=='9'?4:3);i++){
            char word;
            if(digits[start]=='8'){
                word = (char)('t'+(digits[start]-'8')*3+i);

            }else if(digits[start]=='7'){
                word = (char)('p'+(digits[start]-'7')*4+i);

            }else if (digits[start]=='9'){
                word = (char)('w'+(digits[start]-'9')*4+i);

            }else {
                word = (char)('a'+(digits[start]-'2')*3+i);
            }
            templist[start]=word;
            backtrack(list, templist, digits, start+1);
        }
    }
}
// @lc code=end


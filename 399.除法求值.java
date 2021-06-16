import java.util.HashMap;
import java.util.List;

import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,Integer>map = new HashMap<>();
        int index=0;
        for(List<String>liststr:equations){
            if(!map.containsKey(liststr.get(0))){
                map.put(liststr.get(0), index++);
            }
            if(!map.containsKey(liststr.get(1))){
                map.put(liststr.get(1), index++);
            }
        }
        int len = map.size();
        double[][] matric = new double[len][len];
        for(int i=0;i<equations.size();++i){
            int row = map.get(equations.get(i).get(0));
            int col = map.get(equations.get(i).get(1));
            double value = values[i];
            matric[row][col] = value;
            matric[col][row] = 1.0/value;
        }
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();++i){
            if(!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))){
                res[i] = -1.0;
            }else{
                int row = map.get(queries.get(i).get(0));
                int col = map.get(queries.get(i).get(1));
            }
        }

    }
}
// @lc code=end


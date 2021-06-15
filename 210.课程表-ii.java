import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>>edges;
    private int[] visited;
    private boolean isValid;
    private Stack<Integer> stack;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        isValid = true;
        stack = new Stack<>();
        edges = new ArrayList<>();
        for(int i=0;i<numCourses;++i){
            edges.add(new ArrayList<>());
        }
        for(int[]prerequisite:prerequisites){
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i=0;i<numCourses&&isValid;++i){
            if(visited[i]==0){
                dfs(i);
            }
        }
        if(!isValid){
            return new int[0];
        }
        int[]res = new int[numCourses];

        for(int i=0;i<numCourses;++i){
            res[i] = stack.pop();
        }
        return res;
    }
    private void dfs(int u){
        visited[u] = 1;
        for(int v:edges.get(u)){
            if(visited[v]==0){
                dfs(v);
                if(!isValid){
                    return;
                }
            }else if(visited[v]==1){
                isValid = false;
                return;
            }
        }
        visited[u] = 2;
        stack.push(u);
    }
}
// @lc code=end


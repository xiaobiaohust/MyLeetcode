import java.lang.invoke.ClassSpecializer.Factory;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    private List<List<Integer>>edges;
    int[] visited;
    boolean isValid;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        isValid = true;
        for(int i=0;i<numCourses;++i){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;++i){
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses&&isValid;++i){
            if(visited[i]==0){
                dfs(i);
            }
        }
        return isValid;
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
    }
}
// @lc code=end


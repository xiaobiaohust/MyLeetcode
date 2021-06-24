import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */
/**
 * 拓扑排序，判断是否是有向无环图
 * 1、统计每个节点的入度，生成入度表
 * 2、使用queue，存储说有入度为0的阶段
 * 3、queue非空，将队首元素出，和它相邻的节点入度减1，同时入度为0的节点，进入队列
 * 4、如果图是有向无环图，则所有节点都会有进队出队
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[]indegress = new int[numCourses];
        List<List<Integer>>edges = new ArrayList<>();
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;++i){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;++i){
            indegress[prerequisites[i][0]]++;
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;++i){
            if(indegress[i]==0)queue.offer(i);
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int next:edges.get(pre)){
                if(--indegress[next]==0)queue.offer(next);
            }
        }
        return numCourses==0;
    }

}
// class Solution {
//     private List<List<Integer>>edges;
//     int[] visited;
//     boolean isValid;
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         edges = new ArrayList<>();
//         visited = new int[numCourses];
//         isValid = true;
//         for(int i=0;i<numCourses;++i){
//             edges.add(new ArrayList<>());
//         }
//         for(int i=0;i<prerequisites.length;++i){
//             edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
//         }
//         for(int i=0;i<numCourses&&isValid;++i){
//             if(visited[i]==0){
//                 dfs(i);
//             }
//         }
//         return isValid;
//     }
//     private void dfs(int u){
//         visited[u] = 1;
//         for(int v:edges.get(u)){
//             if(visited[v]==0){
//                 dfs(v);
//                 if(!isValid){
//                     return;
//                 }
//             }else if(visited[v]==1){
//                 isValid = false;
//                 return;
//             }
//         }
//         visited[u] = 2;
//     }
// }
// @lc code=end


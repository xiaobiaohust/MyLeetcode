import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */
/**
 * 有向图路径问题
 * 本题可以认为是单源最短路基问题，可以使用dijkstra算法
 */

// @lc code=start
class Solution {
    // dijkstra算法，单源最短路径
    // public int networkDelayTime(int[][] times, int n, int k) {
    //     int[][]m = new int[n][n];
    //     for(int i =0;i<n;++i){
    //         Arrays.fill(m[i], Integer.MAX_VALUE);
    //         m[i][i] = 0;
    //     }
    //     for(int i=0;i<times.length;++i){
    //         m[times[i][0]-1][times[i][1]-1] = times[i][2];
    //     }

    //     int []dis = new int[n];
    //     for(int i=0;i<n;++i){
    //         dis[i] = m[k-1][i];
    //     }
    //     HashSet<Integer> used = new HashSet<>();
    //     used.add(k-1);
    //     for(int i=1;i<n;++i){
    //         int min =Integer.MAX_VALUE;
    //         int minIndex = -1;
    //         for(int j=0;j<n;++j){
    //             if(!used.contains(j)&&dis[j]<min){
    //                 min = dis[j];
    //                 minIndex = j;
    //             }
    //         }
    //         if(minIndex==-1){
    //             break;
    //         }
    //         used.add(minIndex);

    //         for(int j=0;j<n;++j){
    //             int newValue = dis[minIndex]+m[minIndex][j];
    //             if(!used.contains(j)&&m[minIndex][j]!=Integer.MAX_VALUE&&newValue<dis[j]){
    //                 dis[j] = newValue;
    //             }
    //         }
    //     }
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0;i<n;++i){
    //         if(dis[i]==Integer.MAX_VALUE)return -1;
    //         max = Math.max(max, dis[i]);
    //     }
    //     return max;

    // }

     // Bellman-Ford算法,单源最短路径，可以应用于负环图
     public int networkDelayTime(int[][] times, int n, int k) {
        int[][]m = new int[n][n];
        for(int i =0;i<n;++i){
            Arrays.fill(m[i], Integer.MAX_VALUE);
            m[i][i] = 0;
        }
        for(int i=0;i<times.length;++i){
            m[times[i][0]-1][times[i][1]-1] = times[i][2];
        }
        int[] dis = new int[n];
        for(int i=0;i<n;++i){
            dis[i] = m[k-1][i];
        }
        boolean flag = bellmanFord(m,dis,k);

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;++i){
            if(dis[i]==Integer.MAX_VALUE)return -1;
            max = Math.max(max, dis[i]);
        }
        return max;
    }
    public boolean bellmanFord(int[][]m,int[]dis,int k){
        int n = m.length;
        for(int s=0;s<n-1;++s){
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    if(dis[i]==Integer.MAX_VALUE||m[i][j]==Integer.MAX_VALUE) continue;
                    dis[j] = Math.min(dis[j], dis[i]+m[i][j]);
                }
            }
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(dis[j]>dis[i]+m[i][j]) return false;
            }
        }
        return true;
    }

    // Floyd算法,多源最短路径
    // public int networkDelayTime(int[][] times, int n, int k) {
    //     int[][]m = new int[n][n];
    //     for(int i =0;i<n;++i){
    //         Arrays.fill(m[i], Integer.MAX_VALUE);
    //         m[i][i] = 0;
    //     }
    //     for(int i=0;i<times.length;++i){
    //         m[times[i][0]-1][times[i][1]-1] = times[i][2];
    //     }

    //     for(int s=0;s<n;++s){
    //         for(int i=0;i<n;++i){
    //             for(int j=0;j<n;++j){
    //                 if(m[i][s]==Integer.MAX_VALUE||m[s][j]==Integer.MAX_VALUE) continue;
    //                 m[i][j] = Math.min(m[i][j], m[i][s]+m[s][j]);
    //             }
    //         }
    //     }
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0;i<n;++i){
    //         if(m[k-1][i]==Integer.MAX_VALUE)return -1;
    //         max = Math.max(max, m[k-1][i]);
    //     }
    //     return max;
    // }
}
// @lc code=end


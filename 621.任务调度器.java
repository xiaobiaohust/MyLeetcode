import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;;

/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
/**
 * 1、使用map存储每个任务的数量，并且按照数量排序
 * 2、任务数量最多的为len,任务为len的任务个数为num从任务多的开始执行，可以执行len*(n+1)
 * 3、任务数量小于len*(n+1),说明任务数不勾，中间自然会留出很多空闲，则返回(len-1)*(n+1)+num
 * 4、任务数量大于len*(n+1)，则说明任务数比较大，而len比较小，完全能够放下，不需要空闲，tasks.len
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char c: tasks){
            count[c-'A']++;
            max = Math.max(count[c-'A'], max);
        }
        
        for (int i: count){
            if (i == max)
                maxCount++;
        }
        return Math.max(tasks.length, (max-1) * (n+1) + maxCount);
    }
}
// @lc code=end


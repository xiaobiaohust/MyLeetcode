import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=480 lang=java
 *
 * [480] 滑动窗口中位数
 */

// @lc code=start


/**
 * 二分查找+冒泡排序
 */
// class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {
//         double[] res = new double[nums.length - k + 1];
//         int[] window = new int[k];
//         //添加初始值
//         for (int i = 0; i < k; i++) {
//             window[i] = nums[i];
//         }
//         //初始的快排，懒得写直接调用
//         Arrays.sort(window);
//         res[0] = getMid(window);
//         //窗口滑动
//         for (int i = 0; i < nums.length - k; i++) {
//             //需要删除的数
//             int index = search(window, nums[i]);
//             //替换为需要插入的数
//             window[index] = nums[i + k];
//             //向后冒泡
//             while (index < window.length - 1 && window[index] > window[index + 1]) {
//                 swap(window, index, index + 1);
//                 index++;
//             }
//             //向前冒泡
//             while (index > 0 && window[index] < window[index - 1]) {
//                 swap(window, index, index - 1);
//                 index--;
//             }
//             res[i + 1] = getMid(window);
//         }
//         return res;
//     }

//     //交换
//     private void swap(int[] window, int i, int j) {
//         int temp = window[i];
//         window[i] = window[j];
//         window[j] = temp;
//     }

//     //求数组的中位数
//     private double getMid(int[] window) {
//         int len = window.length;
//         if (window.length % 2 == 0) {
//             //避免溢出
//             return window[len / 2] / 2.0 + window[len / 2 - 1] / 2.0;
//         } else {
//             return window[len / 2];
//         }
//     }

//     //最简单的二分查找
//     private int search(int[] window, int target) {
//         int start = 0;
//         int end = window.length - 1;
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             if (window[mid] > target) {
//                 end = mid - 1;
//             } else if (window[mid] < target) {
//                 start = mid + 1;
//             } else {
//                 return mid;
//             }
//         }
//         return -1;
//     }
// }

/**
 * 优先队列+延迟删除
 */
class Solution{
    public double[]medianSlidingWindow(int[]nums,int k){
        double[]res = new double[nums.length-k+1];
        DualHeap dh = new DualHeap(k);
        for(int i=0;i<k;++i){
            dh.insert(nums[i]);
        }
        res[0] = dh.getMedian();
        for(int i=k;i<nums.length;++i){
            dh.insert(nums[i]);
            dh.erase(nums[i-k]);
            res[i-k+1] = dh.getMedian();
        }
        return res;
    }

}


class DualHeap{
    //大根堆，维护较小的一般元素
    private PriorityQueue<Integer> small;
    // 小根堆，维护较大的一半元素
    private PriorityQueue<Integer> large;
    private Map<Integer,Integer> delayed;
    private int smallSize;
    private int largeSize;
    private int k;
    public DualHeap(int k){
        this.small = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer num1,Integer num2){
                return -num1.compareTo(num2);
            }
        });
        this.large = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer num1,Integer num2){
                return num1.compareTo(num2);
            }
        });
        this.delayed = new HashMap<>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian(){
        return (k%2)==1?small.peek():(double)small.peek()/2+(double)large.peek()/2;
    }

    /**
     * 当元素num小于等于small的top元素时，将其加入small中
     * 当元素num 大于small的top元素时，将其加入large中
     * 加入之后，两边元素可能不平衡，进行makeBalance
     * @param num
     */
    public void insert(int num){
        if(small.isEmpty()||num<=small.peek()){
            small.offer(num);
            smallSize++;
        }else{
            large.offer(num);
            largeSize++;
        }
        makeBalance();

    }

    /**
     * 当num小于等于small的top元素时，表示要删除small中的元素
     * 当num大于small的top元素时，表示要删除的是large中的元素
     * 删除元素需要使用延迟删除机制，当要删除的元素在栈顶的时候才删除，否则更新map表，之后再删除
     * @param num
     */
    public void erase(int num){
        delayed.put(num, delayed.getOrDefault(num, 0)+1);
        if(num<=small.peek()){
            smallSize--;
            if(num==small.peek()) {
                prune(small);
            }
        }else{
            largeSize--;
            if(num==large.peek()){
                prune(large);
            }
        }
        makeBalance();
    }

    private void prune(PriorityQueue<Integer>heap){
        while(!heap.isEmpty()){
            int num = heap.peek();
            if(delayed.containsKey(num)){
                heap.poll();
                delayed.put(num, delayed.get(num)-1);
                if(delayed.get(num)==0){
                    delayed.remove(num);
                }
            }else{
                break;
            }
        }
    }
    private void makeBalance(){
        if(smallSize>largeSize+1){
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        }else if(smallSize<largeSize){
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }

}



// @lc code=end


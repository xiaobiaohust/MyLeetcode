/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int res1 = 0;
        int res2 = 0;
        while(i<nums1.length&&j<nums2.length){
            if(i+j>(nums1.length+nums2.length)/2){
                break;
            }
            if(nums1[i]<=nums2[j]){
                res1 = res2;
                res2 = nums1[i];
                i++;
            }else{
                res1 = res2;
                res2 = nums2[j];
                j++;
            }

        }
        if(i+j<=(nums1.length+nums2.length)/2){
            while(i<nums1.length&&i+j<=(nums1.length+nums2.length)/2){
                res1 = res2;
                res2 = nums1[i];
                i++;
            }
            while(j<nums2.length&&i+j<=(nums1.length+nums2.length)/2){
                res1 = res2;
                res2 = nums2[j];
                j++;
            }
        }
        return (nums1.length+nums2.length)%2==0?(double)(res1+res2)/2:res2;
    }
}
// @lc code=end


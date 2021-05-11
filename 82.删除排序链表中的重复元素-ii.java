/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prehead = new ListNode(-1, head);
        if (prehead.next == null || prehead.next.next == null) {
            return prehead.next;
        }
        Boolean flag = false;
        ListNode cur = prehead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                flag = true;
                cur.next = cur.next.next;
            } else if (flag) {
                flag = false;
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        if(flag){
            cur.next = cur.next.next;
        }
        return prehead.next;

    }
}
// @lc code=end

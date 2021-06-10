/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
/**
 * 插入排序
 * 需要一个指向已排序链表的头结点和尾结点，然后从待排序链表中，一个个加进排序链表
 * 切记：已排序链表的末尾一定要置空，要不然很容易导致链表有环
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prehead = new ListNode(0,head);
        ListNode cur = head.next;
        ListNode lastSortedNode = head;
        lastSortedNode.next = null;
        while(cur!=null){
            if(cur.val>=lastSortedNode.val){
                lastSortedNode.next = cur;
                cur = cur.next;
                lastSortedNode = lastSortedNode.next;
                lastSortedNode.next= null;
            }else{
                ListNode temp = prehead;
                while(temp.next.val<cur.val){
                    temp = temp.next;
                }
                ListNode temp1 = temp.next;
                ListNode curnext = cur.next;
                temp.next = cur;
                cur.next =temp1;
                cur = curnext;
            }
        }
        return prehead.next;
    }
}
// @lc code=end

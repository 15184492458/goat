package com.goat.api.lintcode.simple;

/**
 * 翻转链表
 * 描述
     翻转一个链表

     样例
     样例 1:

     输入: 1->2->3->null
     输出: 3->2->1->null
     样例 2:

     输入: 1->2->3->4->null
     输出: 4->3->2->1->null
     挑战
     在原地一次翻转完成
 */
public class ReverseLinkList {

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here A->B->C
        ListNode pre = null, next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //Definition for ListNode
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}

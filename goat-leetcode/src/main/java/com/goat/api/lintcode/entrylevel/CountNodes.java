package com.goat.api.lintcode.entrylevel;

public class CountNodes {

    /**
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public int countNodes(ListNode head) {
        // write your code here
        if (head == null) return 0;
        int count = 1;
        while (head.next != null){
            ++count;
            head = head.next;
        }
        return count;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}

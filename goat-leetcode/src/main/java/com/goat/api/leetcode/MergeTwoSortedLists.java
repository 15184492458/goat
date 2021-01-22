package com.goat.api.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并两个有序的链表：
 *  将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

     示例：

     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode listOne = new ListNode(4);
        ListNode listTwo = new ListNode(2,listOne);
        ListNode listThree = new ListNode(1,listTwo);

        ListNode listFour = new ListNode(4);
        ListNode listFive = new ListNode(3,listFour);
        ListNode listSix = new ListNode(1,listFive);

        ListNode result = mergeTwoSorted(listThree,listSix);
        while (result != null){
            System.out.print(result.val + "-");
            result = result.next;
        }
    }

    public static ListNode mergeTwoSorted(ListNode l1, ListNode l2){
        ListNode preHread = new ListNode(-1);
        ListNode tmp = preHread;
        while (l1 != null){
            while (l2 != null){
                if (l1.val > l2.val){
                    tmp.next = new ListNode(l2.val);
                    tmp = tmp.next;
                    l2 = l2.next;
                }else {
                    tmp.next = new ListNode(l1.val);
                    tmp = tmp.next;
                    l1 = l1.next;
                    break;
                }
            }
        }
        if (l1 == null) tmp.next = l2;
        if (l2 == null) tmp.next = l1;
        return preHread.next;
    }

    /**
     * 暴力解法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoSorted1(ListNode l1, ListNode l2){
        List<Integer> list = new ArrayList();
        while (l1 != null){
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        if (list.size() < 1) return null;
        ListNode headNode = new ListNode(list.get(0));
        ListNode tmp = headNode;
        for (int i = 1;i < list.size();++i){
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }
        return headNode;
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoSorted2(ListNode l1, ListNode l2){
        ListNode preHead = new ListNode(-1);
        ListNode tmp = preHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static ListNode mergeTwoSorted3(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoSorted3(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoSorted3(l1, l2.next);
        return l2;
    }

    static class ListNode{

        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        public int getVal() {
            return val;
        }
    }
}

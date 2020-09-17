package com.ranjun1999.personalutils.算法.nowcoder.linkedlist;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * @Author: ranjun
 * @Date: 2020/9/2 15:59
 */
public class mergeTwoLists {

    /**
     * 将两个有序的链表合并为一个新链表，
     * 要求新的链表是通过拼接两个链表的节点来生成的。
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next =l2;
                node = node.next;
                l2 = l2.next;
            }else if (l1.val <= l2.val){
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return dummy.next;
    }
}

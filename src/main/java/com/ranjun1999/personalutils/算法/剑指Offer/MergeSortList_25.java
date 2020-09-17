package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * 合并两个排序的列表
 * @Author: ranjun
 * @Date: 2020/9/14 15:35
 */
public class MergeSortList_25 {

    /**
     * 输入两个递增排序的列表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeSortList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        ListNode l1 = head1,l2 = head2;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            } else if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
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

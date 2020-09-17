package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ListNode;


/**
 * 链表中倒数第k个节点
 * @Author: ranjun
 * @Date: 2020/9/14 14:00
 */
public class FindKPathToTail_22 {

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。
     * @param head
     * @param k
     * @return
     */
    public static ListNode findKPathToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode first = head;
        ListNode behind = null;
        for (int i = 0; i < k - 1; i++) {
            if (first.next != null) {
                first = first.next;
            }else {
                return null;
            }
        }
        behind = head;
        while (first.next != null) {
            first = first.next;
            behind = behind.next;
        }
        return behind;
    }

}

package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * @Author: ranjun
 * @Date: 2020/9/14 15:07
 */
public class ReverseList_24 {

    /**
     * 输入一个链表的头结点，反转该链表并输出反转后链表的头结点
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node= head;
        while (node != null) {
            ListNode nextNode = dummy.next;
            node.next = nextNode;
            dummy.next = node;
            node = node.next;
        }
        return dummy.next;
    }
}

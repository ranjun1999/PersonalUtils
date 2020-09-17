package com.ranjun1999.personalutils.算法.nowcoder.linkedlist;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * @Author: ranjun
 * @Date: 2020/9/2 10:05
 */
public class ReverseList {

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode node = head;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = newHead;
            newHead = node;
            node = nextNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
            ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
            ListNode.printListNode(head);
            ListNode.printListNode(reverseList(head));
    }
}

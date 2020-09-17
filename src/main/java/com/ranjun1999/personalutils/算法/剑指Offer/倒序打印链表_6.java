package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * 输入一个链表的头结点，从尾到头打印链表
 * @Author: ranjun
 * @Date: 2020/7/30 17:11
 */
public class 倒序打印链表_6 {


    static ListNode printReverse(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode head = new ListNode(listNode.val);
        listNode = listNode.next;
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        listNode = printReverse(listNode);
        ListNode.printListNode(listNode);
    }
}

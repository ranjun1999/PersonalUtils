package com.ranjun1999.personalutils.算法.nowcoder.linkedlist;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * @Author: ranjun
 * @Date: 2020/9/3 10:32
 */
public class RemoveNthFromEnd {


    /**
     * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
     * 例如，
     *  给出的链表为:1->2->3->4->5, n= 2.
     *  删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first =  head;
        int i = 0;
        while (first != null && i < n) {
            first = first.next;
            i++;
        }
        while (first != null) {
            first = first.next;
            dummy = dummy.next;
        }
        ListNode removeNode = dummy.next;
        if (removeNode == head) {
            dummy.next = removeNode.next;
            removeNode.next = null;
            return dummy.next;
        }else {
            dummy.next = removeNode.next;
            removeNode.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2));
        ListNode.printListNode(removeNthFromEnd(listNode,2));
    }
}

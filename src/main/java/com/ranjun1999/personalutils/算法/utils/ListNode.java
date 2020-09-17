package com.ranjun1999.personalutils.算法.utils;

/**
 * 简单的链表结构
 * @Author: ranjun
 * @Date: 2019/11/23 16:09
 */
public class ListNode {

    public int val;
    public ListNode next;

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode(){}

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }


    public ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode(ListNode next, int val) {
        this.val = val;
        this.next = next;
    }


    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

}

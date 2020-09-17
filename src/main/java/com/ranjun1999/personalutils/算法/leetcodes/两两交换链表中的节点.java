package com.ranjun1999.personalutils.算法.leetcodes;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @Author: ranjun
 * @Date: 2019/12/5 20:20
 */
public class 两两交换链表中的节点 {

    /**
     * 递归调用
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        //当节点为空或者链表只剩一个节点时，递归结束
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    //非递归过程
    public ListNode swapPairs_2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode first = head, second, k = head;

        while (first != null && first.next != null) {
            second = first.next;
            if (k != head){
                k.next = second;            }

            first.next = second.next;
            second.next = first;

            if (k == head) {
                head = second;
            }

            k = first;
            first = first.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new ListNode(new ListNode(new ListNode(4),3),2),1);
//        head = swap(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

package com.ranjun1999.personalutils.算法.leetcodes;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * @Author: ranjun
 * @Date: 2019/12/5 21:53
 */
public class K个一组翻转链表 {

    /**
     * 递归尾插法
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }


    /**
     * 递归头插法
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverse(ListNode head,int k) {

        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        //若果节点数不为K，保持原有顺序返回头结点
        if (count == k) {
            ListNode tail = head, node = head.next;
            while (count != 1) {
                count --;
                ListNode temp = node.next;
                tail.next = node.next;
                node.next = head;
                head = node;
                node = temp;
            }
            tail.next = reverse(node, k);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new ListNode(new ListNode(new ListNode(new ListNode(5),4),3),2),1);
//        ListNode head = new ListNode(new ListNode(2),1);
        head = reverse(head,3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}

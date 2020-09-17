package com.ranjun1999.personalutils.算法.leetcodes;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @Author: ranjun
 * @Date: 2019/11/28 22:01
 */
public class 删除链表倒数第n个节点 {

    /**
     * 双指针法
     *
     * 初始first节点与second节点的距离为n
     * 当second节点到了链表末尾是，first节点即倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFormEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode curr = dummyHead;

        //要删除节点的前一个节点
        ListNode first = dummyHead;

        ListNode second = dummyHead;

        for (int i = 0; i < n; i++) {
            curr = curr.next;
            second = curr;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        ListNode remove = first.next;
        first.next = remove.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);

        node = removeNthFormEnd(node,2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}

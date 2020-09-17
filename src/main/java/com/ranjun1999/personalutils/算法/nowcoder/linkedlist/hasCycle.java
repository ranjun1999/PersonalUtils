package com.ranjun1999.personalutils.算法.nowcoder.linkedlist;

import com.ranjun1999.personalutils.算法.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ranjun
 * @Date: 2020/9/2 11:08
 */
public class hasCycle {

    /**
     * 判断给定的链表中是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (nodes.contains(next)) {
                return true;
            } else nodes.add(node);
            node = next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode;
        System.out.println(hasCycle2(listNode));
    }
}

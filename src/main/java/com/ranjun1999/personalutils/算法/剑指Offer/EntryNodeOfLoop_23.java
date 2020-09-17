package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * @Author: ranjun
 * @Date: 2020/9/14 14:30
 */
public class EntryNodeOfLoop_23 {

    /**
     * 判断链表中是否存在环
     * 使用快慢指针分别从链表的头结点出发，快指针一次走两步，慢指针一次走一步；如果快慢指针相遇，则链表中有环
     * 如果快指针走到了链表末尾(fast.next == null)都没有和慢指针相遇，则链表中无环
     * @param head
     * @return
     */
    public static ListNode meetingNode(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head.next;
        if (slow == null)
            return null;
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 如果环中有n个节点，则node1先从头指针移动n步，然后node1,node2以相同速度移动。当第二个指针移动到环的入口节点时，第一个指针已经围绕着环走了一圈，又回到了入口节点，
     * @param head
     * @return
     */
    public static ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null) {
            return null;
        }
        //计算环中节点的数目
        int nodesInLoop = 1;
        ListNode node = meetingNode;
        while (node.next != meetingNode) {
            node = node.next;
            nodesInLoop++;
        }
        node = head;
        //移动node,次数为环中节点的数目
        for (int i = 0; i < nodesInLoop; i++) {
            node = node.next;
        }

        ListNode node2 = head;
        while (node != node2) {
            node = node.next;
            node2 = node2.next;
        }
        return node;
    }
}

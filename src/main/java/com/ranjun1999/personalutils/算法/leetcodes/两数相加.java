package com.ranjun1999.personalutils.算法.leetcodes;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author: ranjun
 * @Date: 2019/11/23 16:11
 */
public class 两数相加 {

    /**
     * 初等数学法
     * 使用carrier变量来保存进位，并从包含最低有效位的表头开始模拟逐位相加的过程。
     * 时间复杂度：O(max(m,n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m,n) 次。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        //保存进位
        int carrier = 0;

        while (l1 != null || l2 != null) {
            //若当前节点为空，默认0
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;

            //节点元素与进位相加
            int sum = x + y + carrier;

            carrier = sum / 10;

            //保存当前节点数据，并将dummy指向下一位。
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;

            if (l1 != null )l1 = l1.next;
            if (l2 != null )l2 = l2.next;
        }

        if (carrier > 0) {
            dummy.next = new ListNode(carrier);
        }
        return head.next;
    }

}

package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author zhaotianzeng
 * @date 2019-08-13 17:53
 * @version V1.0
 */
public class Solution0002 {
    @Test
    public void test() {
        ListNode l1 = ListNode.create(2, 4, 3);

        ListNode l2 = ListNode.create(5, 6, 4);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }

    @Test
    public void test2() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
    }

    /**
     * 相加
     * 使用临时变量carried标记是否需要进一位。
     * 如果最终的总和大于10，需要再后面再进一位。
     * 比如[5] [5] 最后输出的应该是 [0] [1]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carried = 0;
        ListNode tempNode = new ListNode(-1);
        ListNode node = tempNode;
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        int sum = 0;
        while (l1Next != null || l2Next != null) {
            sum = 0;
            if (l1Next != null) {
                sum += l1Next.val;
                l1Next = l1Next.next;
            }
            if (l2Next != null) {
                sum += l2Next.val;
                l2Next = l2Next.next;
            }
            if (carried > 0) {
                sum += carried;
                carried = 0;
            }
            if (sum >= 10) {
                carried += 1;
            }

            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        if (sum >= 10) {
            node.next = new ListNode(1);
        }

        return tempNode.next;
    }


}
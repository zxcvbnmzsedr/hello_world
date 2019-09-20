package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 *
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
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author zhaotianzeng
 * @date 2019/9/20 11:03 上午
 * @version V1.0
 */
public class Solution0025 {
    @Test
    public void test1() {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);

        ListNode listNode = reverseKGroup(head, 2);
        System.out.println(listNode);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);

        ListNode listNode = reverseKGroup(head, 1);
        System.out.println(listNode);
    }

    /**
     * 1->2->3->4->5 分组，每组翻转
     * 使用空间换时间，利用栈将链表弹出翻转。占用O(k)空间
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_1(ListNode head, int k) {
        int size = 0;
        ListNode[] stack = new ListNode[k];

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next = dummy.next;
        while (next != null) {
            for (int i = 0; i < k && next != null; i++) {
                stack[size++] = next;
                next = next.next;
            }
            if (size != k) {
                return dummy.next;
            }
            while (size != 0) {
                current.next = stack[--size];
                current = current.next;
            }
            current.next = next;
        }


        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tem = dummy;
        while (tem != null) {
            tem = reverseList(tem, k);

        }
        return dummy.next;
    }

    /**
     * 链表全翻转
     *
     * @param prev
     * @return
     */
    public ListNode reverseList(ListNode prev, int k) {
        ListNode last = prev;

        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            if (last == null && k != i) {
                return null;
            }
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while (curr != last) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next;

        }
        return tail;

    }
}
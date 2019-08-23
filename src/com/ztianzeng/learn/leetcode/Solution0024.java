package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author zhaotianzeng
 * @date 2019/8/23 5:16 下午
 * @version V1.0
 */
public class Solution0024 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(head);
        System.out.println(listNode.toString());

    }

    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;



        return temp;
    }
}
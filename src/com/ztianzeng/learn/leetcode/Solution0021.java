package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author zhaotianzeng
 * @date 2019/9/19 1:48 下午
 * @version V1.0
 */
public class Solution0021 {

    @Test
    public void test1() {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode listNode = mergeTwoLists(l1_1, l2_1);
        System.out.println(listNode);

    }

    @Test
    public void test2() {
        ListNode l1_1 = new ListNode(-9);
        ListNode l1_2 = new ListNode(3);
        l1_1.next = l1_2;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(7);
        l2_1.next = l2_2;

        ListNode listNode = mergeTwoLists(l1_1, l2_1);
        System.out.println(listNode);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode link = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int left = l1.val;
                int right = l2.val;
                if (right > left) {
                    link.next = new ListNode(left);
                    l1 = l1.next;
                } else {
                    link.next = new ListNode(right);
                    l2 = l2.next;
                }
                link = link.next;
            } else if (l1 == null) {
                while (l2 != null) {
                    link.next = new ListNode(l2.val);
                    l2 = l2.next;
                    link = link.next;
                }
            } else {
                while (l1 != null) {
                    link.next = new ListNode(l1.val);
                    l1 = l1.next;
                    link = link.next;
                }
            }


        }


        return head.next;
    }
}
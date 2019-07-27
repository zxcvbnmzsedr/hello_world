package com.ztianzeng.learn.leetcode;

import org.junit.Test;

/**
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * @author zhaotianzeng
 * @date 2019-07-27 17:32
 * @version V1.0
 */
public class RemoveLinkedListElements {

    @Test
    public void test() {
        ListNode o1 = new ListNode(1);
        ListNode o2 = new ListNode(2);
        ListNode o3 = new ListNode(3);
        ListNode o4 = new ListNode(4);
        ListNode o5 = new ListNode(5);
        ListNode o6 = new ListNode(6);

        o1.next = o2;
        o2.next = o3;
        o3.next = o4;
        o4.next = o5;
        o5.next = o6;

        ListNode listNode = removeElements(o1, 6);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    public void test1() {
        ListNode o1 = new ListNode(1);

        ListNode listNode = removeElements(o1, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode temp = header;

        while (temp.next != null) {

            if (val == temp.next.val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }


        }
        return header.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
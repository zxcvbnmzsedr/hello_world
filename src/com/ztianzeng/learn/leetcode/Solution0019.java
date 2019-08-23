package com.ztianzeng.learn.leetcode;

import org.junit.Test;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5. Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author zhaotianzeng
 * @date 2019/8/22 5:43 下午
 * @version V1.0
 */
public class Solution0019 {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new Normal().removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static class Normal extends Solution0019 {
        /**
         * 新增虚拟节点p q 都指向head的第一个元素。
         * q先走n步，然后pq一起向前走。等到q获取到了null，q的对应的元素正好是对应的n的位置。
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode p = dummyHead;
            ListNode q = dummyHead;
            while (n != 0) {
                q = q.next;
                n--;
            }
            while (q.next != null) {
                p = p.next;
                q = q.next;
            }
            p.next = p.next.next;
            return dummyHead.next;
        }
    }

    public static class Baoli extends Solution0019 {
        /**
         * 暴力处理法，统计出链表总长度，在下一次处理的时候判断到那个节点之后在删除
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int k = 0;
            ListNode al = head;
            while (al != null) {
                k++;
                al = al.next;
            }
            ListNode bl = head;
            int temp = 0;
            while (bl != null) {
                if (temp++ == k - n) {
                    bl = bl.next.next;
                }
            }
            return head;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
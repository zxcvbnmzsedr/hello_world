package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * 反转一个单链表。
 *
 * @author zhaotianzeng
 * @date 2019-07-29 09:40
 * @version V1.0
 */
public class Solution0206 {
    @Test
    public void test() {
        ListNode o1 = new ListNode(1);
        ListNode o2 = new ListNode(2);
        ListNode o3 = new ListNode(3);
        ListNode o4 = new ListNode(4);
        ListNode o5 = new ListNode(5);

        o1.next = o2;
        o2.next = o3;
        o3.next = o4;
        o4.next = o5;


        ListNode listNode = reverseList(o1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
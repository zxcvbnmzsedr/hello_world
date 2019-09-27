package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author zhaotianzeng
 * @date 2019/9/27 4:28 下午
 * @version V1.0
 */
public class Link_删除链表的倒数第N个节点 {

    @Test
    public void test1() {
        ListNode listNode = ListNode.create(1, 2, 3, 4, 5);
        ListNode node = removeNthFromEnd(listNode, 2);
        System.out.println(node);
    }

    @Test
    public void test2() {
        ListNode listNode = ListNode.create(1);
        ListNode node = removeNthFromEnd(listNode, 1);
        System.out.println(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }
        ListNode q = new ListNode(-1);
        q.next = head;
        ListNode quick = q;
        ListNode slow = q;
        int i = 0;
        while (quick != null && quick.next != null) {
            if (n > i++) {
                quick = quick.next;
            } else {
                slow = slow.next;
                quick = quick.next;
            }
        }

        slow.next = slow.next.next;

        return q.next;
    }
}
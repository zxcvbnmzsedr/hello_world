package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * @author zhaotianzeng
 * @date 2019/9/28 10:33 上午
 * @version V1.0
 */
public class Link_环形链表 {
    @Test
    public void test1() {
        ListNode listNode = ListNode.create(3, 2, 0, -4);
        listNode.next.next.next = listNode.next;
        boolean b = hasCycle(listNode);
        Assert.assertTrue(b);
    }

    @Test
    public void test2() {
        ListNode listNode = ListNode.create(3, 2, 0, -4);

        boolean b = hasCycle(listNode);
        Assert.assertFalse(b);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
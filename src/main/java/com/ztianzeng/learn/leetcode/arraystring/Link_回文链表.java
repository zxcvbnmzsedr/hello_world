package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author zhaotianzeng
 * @date 2019/9/28 9:34 上午
 * @version V1.0
 */
public class Link_回文链表 {
    @Test
    public void test1() {
        ListNode listNode = ListNode.create(1, 2, 1);
        Assert.assertTrue(isPalindrome(listNode));
    }

    @Test
    public void test2() {
        ListNode listNode = ListNode.create(1, 2, 2, 1);
        Assert.assertTrue(isPalindrome(listNode));
    }

    public boolean isPalindrome(ListNode head) {
        //快慢指针找到链表的中点
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // 慢指针走v，快走2v，快的到最后，慢的正好到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 奇数节点需要删除最后一个,因为奇数fast最后一个必定是不为空的
        if (fast != null) {
            slow = slow.next;
        }
        // 翻转链表
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        ListNode cur = head;
        while (pre != null) {
            if (cur.val != pre.val) {
                return false;
            }
            cur = cur.next;
            pre = pre.next;
        }

        return true;
    }
}
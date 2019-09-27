package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author zhaotianzeng
 * @date 2019/9/27 4:57 下午
 * @version V1.0
 */
public class Link_反转链表 {
    @Test
    public void test() {
        ListNode a = ListNode.create(1, 2, 3, 4, 5);
        System.out.println(reverseList(a));
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }
}
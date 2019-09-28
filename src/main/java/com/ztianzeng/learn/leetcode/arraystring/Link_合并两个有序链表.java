package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author zhaotianzeng
 * @date 2019/9/28 9:13 上午
 * @version V1.0
 */
public class Link_合并两个有序链表 {
    @Test
    public void test() {
        ListNode l1 = ListNode.create(1, 2, 4);
        ListNode l2 = ListNode.create(1, 3, 4);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1Link = l1;
        ListNode l2Link = l2;

        ListNode res = new ListNode(-1);
        ListNode result = res;

        while (l1Link != null || l2Link != null) {
            if (l1Link != null && l2Link != null) {
                if (l1Link.val <= l2Link.val) {
                    result.next = l1Link;
                    l1Link = l1Link.next;
                } else {
                    result.next = l2Link;
                    l2Link = l2Link.next;
                }
            } else if (l1Link != null) {
                result.next = l1Link;
                l1Link = l1Link.next;
            } else {
                result.next = l2Link;
                l2Link = l2Link.next;
            }

            result = result.next;
        }

        return res.next;
    }
}
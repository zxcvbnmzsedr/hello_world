package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author zhaotianzeng
 * @date 2019/9/19 6:10 下午
 * @version V1.0
 */
public class Solution0023 {
    @Test
    public void test() {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode1 = lists[0];
        ListNode listNode2 = mergeTwoLists(listNode1, lists[1]);
        for (int i = 2; i < lists.length; i++) {
            listNode2 = mergeTwoLists(listNode2, lists[i]);
        }
        return listNode2;
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
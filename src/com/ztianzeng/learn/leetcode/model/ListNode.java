package com.ztianzeng.learn.leetcode.model;

import com.ztianzeng.learn.leetcode.code.AddTwoNumbers;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(val + " ");
        ListNode node = next;
        while (node != null) {
            stringBuffer.append(node.val + " ");
            node = node.next;
        }
        return stringBuffer.toString();
    }
}
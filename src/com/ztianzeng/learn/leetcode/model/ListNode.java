package com.ztianzeng.learn.leetcode.model;

import com.ztianzeng.learn.leetcode.code.AddTwoNumbers;

import java.util.Optional;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(val).append("->");
        ListNode node = next;
        while (node != null) {
            stringBuffer.append(node.val);
            Optional.ofNullable(node.next).ifPresent(n -> stringBuffer.append("->"));

            node = node.next;
        }
        return stringBuffer.toString();
    }
}
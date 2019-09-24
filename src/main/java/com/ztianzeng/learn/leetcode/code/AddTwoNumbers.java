package com.ztianzeng.learn.leetcode.code;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * 两个非空的链表代表两个非负的整数
 * 数据被储存在相反的顺序并且每个节点都包含了单独的数据
 * 增加两个数并且使用链表返回
 * 你可以假设两个数字都不包含前导零，除了零本身
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)   -----> 342 + 465 = 807
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    @Test
    public void test() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        System.out.println(addTwoNumbers(l1, l2));
    }


    /**
     * 两个数字相加
     * 思路：
     * 1. 先把l1和l2相加在一起，和取余赋给结果链表
     * 2. 把和除以10也就是舍去一位，再相加取余
     * 3. 如果最后的和大于10，则链表后追加一个值为1的节点
     *
     * @param l1 第一个数字的倒序链表
     * @param l2 第二个数字的倒叙链表
     * @return 输出两个数字和的倒叙链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if(l1 !=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum+=l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        if(sum / 10 == 1){
            node.next = new ListNode(1);
        }
        return result.next;
    }

}

package com.ztianzeng.learn.leetcode;

import com.ztianzeng.learn.leetcode.model.ListNode;
import org.junit.Test;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaotianzeng
 */
public class Solution02_05_ {
    @Test
    public void test2() {
        ListNode l1 = ListNode.create(7,1,6);
        ListNode l2 = ListNode.create(5,9,2);
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.create(2,4,3);
        ListNode l2 = ListNode.create(5,6,4);
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode result = p ;
        int s = 0;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            int current = l1Val + l2Val + s;
            s = 0;
            if (current >= 10) {
                current = current % 10;
                s = 1;
            }
            p.next = new ListNode(current);
            p = p.next;
        }


        return result.next;
    }
}

package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 *
 * 链接：https://leetcode-cn.com/problems/min-stack
 *
 * @author zhaotianzeng
 * @date 2019-07-26 13:30
 * @version V1.0
 */
public class Solution155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public Solution155() {
        this.stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (Objects.equals(pop, minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    @Test
    public void test() {

        Solution155 minStack = new Solution155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(minStack.getMin(), -3);

        minStack.pop();
        Assert.assertEquals(minStack.top(), 0);
        Assert.assertEquals(minStack.getMin(), -2);
    }

    @Test
    public void test2() {

        Solution155 minStack = new Solution155();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        Assert.assertEquals(minStack.getMin(), -1024);

        minStack.pop();
        Assert.assertEquals(minStack.getMin(), -1024);
        minStack.pop();
        Assert.assertEquals(minStack.getMin(), 512);
    }
}
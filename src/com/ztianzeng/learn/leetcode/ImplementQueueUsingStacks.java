package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 * @author zhaotianzeng
 * @date 2019-07-30 17:52
 * @version V1.0
 */
public class ImplementQueueUsingStacks {
    @Test
    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        Assert.assertEquals(queue.peek(),1);
        Assert.assertEquals(queue.pop(),1);
        Assert.assertFalse(queue.empty());
    }

    /**
     * 使用辅助栈逆序元素
     */
    class MyQueue {
        /**
         * 主栈
         */
        private Stack<Integer> main;

        /**
         *  辅助栈
         */
        private Stack<Integer> help;

        /** Initialize your data structure here. */
        public MyQueue() {
            main = new Stack<>();
            help = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!main.empty()) {
                help.push(main.pop());
            }
            help.push(x);
            while (!help.empty()) {
                main.push(help.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return main.pop();
        }

        /** Get the front element. */
        public int peek() {
            return main.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return main.empty();
        }
    }
}
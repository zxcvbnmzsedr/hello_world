package com.ztianzeng.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-07-22 16:12
 */
public class Solution0104 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode r9 = new TreeNode(9);
        TreeNode r15 = new TreeNode(15);
        TreeNode r20 = new TreeNode(20);
        TreeNode r7 = new TreeNode(7);

        root.left = r9;
        root.right = r20;
        r20.left = r15;
        r20.right = r7;


        int i = maxDepth(root);
        Assert.assertEquals(i, 3);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);

        root.left = r2;
        int i = maxDepth(root);
        Assert.assertEquals(i, 2);
    }

    /**
     * 最大深度
     *
     * @param root 根节点
     * @return 深度
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
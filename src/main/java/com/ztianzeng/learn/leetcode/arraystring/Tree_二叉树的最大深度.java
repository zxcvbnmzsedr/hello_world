package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @author zhaotianzeng
 * @date 2019/9/28 2:03 下午
 * @version V1.0
 */
public class Tree_二叉树的最大深度 {
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.create(3, 9, 20, null, null, 15, 7);
        System.out.println(treeNode);
        Assert.assertEquals(maxDepth(treeNode), 3);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }

    }

}
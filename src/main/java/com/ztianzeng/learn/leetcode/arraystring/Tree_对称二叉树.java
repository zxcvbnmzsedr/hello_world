package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @author zhaotianzeng
 * @date 2019/9/28 3:28 下午
 * @version V1.0
 */
public class Tree_对称二叉树 {
    @Test
    public void test1() {
        TreeNode treeNode = TreeNode.create(1, 2, 2, 3, 4, 4, 3);
        boolean symmetric = isSymmetric(treeNode);
        Assert.assertTrue(symmetric);
    }

    @Test
    public void test2() {
        TreeNode treeNode = TreeNode.create(1, 2, 2, null, 3, null, 3);
        boolean symmetric = isSymmetric(treeNode);
        Assert.assertFalse(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val)
                && isMirror(right.left, left.right)
                && isMirror(left.left, right.right);
    }
}
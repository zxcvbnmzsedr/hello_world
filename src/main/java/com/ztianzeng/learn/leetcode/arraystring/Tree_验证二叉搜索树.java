package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author zhaotianzeng
 * @date 2019/9/28 2:56 下午
 * @version V1.0
 */
public class Tree_验证二叉搜索树 {

    @Test
    public void test1() {
        TreeNode treeNode = TreeNode.create(5, 1, 4, null, null, 3, 6);
        Assert.assertFalse(isValidBST(treeNode));
    }

    @Test
    public void test2() {
        TreeNode treeNode = TreeNode.create(2, 1, 3);
        Assert.assertTrue(isValidBST(treeNode));
    }

    @Test
    public void test3() {
        TreeNode treeNode = TreeNode.create(1, 1);
        Assert.assertFalse(isValidBST(treeNode));
    }

    @Test
    public void test4() {
        TreeNode treeNode = TreeNode.create(10, 5, 15, null, null, 6, 20);
        Assert.assertFalse(isValidBST(treeNode));
    }

    @Test
    public void test5() {
        TreeNode treeNode = TreeNode.create(3, 1, 5, 0, 2, 4, 6);
        Assert.assertTrue(isValidBST(treeNode));
    }

    @Test
    public void test6() {
        TreeNode treeNode = TreeNode.create(3, 1, 5, 0, 2, 4, 6, null, null, null, 3);
        Assert.assertFalse(isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }


    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }


}
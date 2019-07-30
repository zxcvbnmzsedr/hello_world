package com.ztianzeng.learn.leetcode;

import org.junit.Test;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 *
 * 翻转一棵二叉树。
 * @author zhaotianzeng
 * @date 2019-07-30 17:35
 * @version V1.0
 */
public class InvertBinaryTree {

    @Test
    public void test(){

    }
    /**
     * 遍历二叉树 交换左右位置
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = root.left;

        TreeNode right = root.right;

        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
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
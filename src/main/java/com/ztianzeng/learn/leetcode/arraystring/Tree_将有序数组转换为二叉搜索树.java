package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.TreeNode;
import org.junit.Test;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author zhaotianzeng
 * @date 2019/9/28 3:52 下午
 * @version V1.0
 */
public class Tree_将有序数组转换为二叉搜索树 {
    @Test
    public void test() {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBst(nums, 0, nums.length - 1);
    }

    private TreeNode toBst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = toBst(nums, left, mid - 1);
        treeNode.right = toBst(nums, mid + 1, right);
        return treeNode;
    }

}
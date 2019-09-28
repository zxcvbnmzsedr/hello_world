package com.ztianzeng.learn.leetcode.arraystring;

import com.ztianzeng.learn.leetcode.model.TreeNode;
import com.ztianzeng.learn.leetcode.utils.PrintUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author zhaotianzeng
 * @date 2019/9/28 3:41 下午
 * @version V1.0
 */
public class Tree_二叉树的层次遍历 {
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.create(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> lists = levelOrder(treeNode);
        for (List<Integer> list : lists) {
            PrintUtil.print(list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(result, root, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, TreeNode root, int leave) {
        if (result.size() == leave) {
            result.add(new ArrayList<>());
        }
        result.get(leave).add(root.val);
        if (root.left != null) {
            helper(result, root.left, leave + 1);
        }
        if (root.right != null) {
            helper(result, root.right, leave + 1);
        }
    }
}
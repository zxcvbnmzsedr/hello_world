package com.ztianzeng.learn.leetcode;


import com.ztianzeng.learn.leetcode.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaotianzeng
 */
public class Solution0112 {

    @Test
    public void a() {
        TreeNode treeNode = TreeNode.create(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        Assert.assertTrue(hasPathSum(treeNode, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 如果是叶子节点节点，这个时候sum == 0 就是说明有求和为空的情况
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

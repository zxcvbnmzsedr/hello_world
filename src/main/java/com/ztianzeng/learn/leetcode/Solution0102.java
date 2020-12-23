package com.ztianzeng.learn.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.ztianzeng.learn.leetcode.model.TreeNode;
import org.junit.Test;

import java.util.*;

public class Solution0102 {
    @Test
    public void test() {
        List<List<Integer>> lists = levelOrder(TreeNode.create(3, 9, 20, null, null, 15, 7));
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        while (!tree.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int n = tree.size();
            for (int i = 0; i < n; i++) {
                TreeNode peek = tree.poll();
                tmp.add(peek.val);
                if (peek.left != null) {
                    tree.offer(peek.left);
                }
                if (peek.right != null) {
                    tree.offer(peek.right);
                }

            }
            result.add(tmp);
        }
        return result;
    }
}

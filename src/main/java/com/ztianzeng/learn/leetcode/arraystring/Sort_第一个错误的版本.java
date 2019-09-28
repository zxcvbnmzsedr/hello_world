package com.ztianzeng.learn.leetcode.arraystring;

import org.junit.Assert;
import org.junit.Test;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 *
 * @author zhaotianzeng
 * @date 2019/9/28 6:07 下午
 * @version V1.0
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Sort_第一个错误的版本 {
    @Test
    public void test() {
        Assert.assertEquals(4, firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        // 二分查找
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // 没用 mid - 1，是以为 mid - 1 可能不是 BadVersion，因此需要保留 mid
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;

    }

    boolean isBadVersion(int version) {
        return 4 == version;
    }

}
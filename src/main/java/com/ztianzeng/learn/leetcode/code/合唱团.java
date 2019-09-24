package com.ztianzeng.learn.leetcode.code;

import java.util.Scanner;

/**
 * 有 n 个学生站成一排，每个学生有一个能力值，
 * 牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 * 要求相邻两个学生的位置编号的差不超过 d，
 * 使得这 k 个学生的能力值的乘积最大，
 * 你能返回最大的乘积吗？
 */
public class 合唱团 {
    /**
     * 每个输入包含 1 个测试用例。
     * 每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
     * 接下来的一行，包含 n 个整数，
     * 按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
     * 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //总人数
            int n = sc.nextInt();
            //学生能力值数组，第i个人直接对应arr[i]
            int[] arr = new int[n + 1];
            //初始化
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            //选择的学生数
            int kk = sc.nextInt();
            //间距
            int dd = sc.nextInt();
            System.out.println(max(n, arr, kk, dd));
        }
    }

    /**
     * @param a 每个学生的能力值
     * @param k 挑选出的学生数
     * @param d 位置编号相差数
     * @return
     */
    public static long max(int n, int[] a, int k, int d) {
        // 前n个学生中，选择k个，可以看错前n个学生中选择最后一个和前面的k-1个，并且k-1个和这1个满足约束条件
        // 记第k个人的位置为one,则可以用f[one][k]表示从n个人中选择k个的方案。
        // 需要从one前面的left个人里面，选择k-1个，
        // 这里left表示k-1个人中最后一个（即第k-1个）人的位置，因此，子问题可以表示成f[left][k-1].
        long[][] f = new long[n + 1][k + 1];
        long[][] g = new long[n + 1][k + 1];

        //初始化k=1的情况
        for (int one = 1; one <= n; one++) {
            f[one][1] = a[one];
            g[one][1] = a[one];
        }
        for (int kk = 2; kk <= k; kk++) {
            for (int one = kk; one <= n; one++) {
                //求解当one和k定的时候，最大的分割点
                long tempmax = Long.MIN_VALUE;
                long tempmin = Long.MAX_VALUE;

                for (int left = Math.max(k - 1, one - d); left <= one - 1; left++) {
                    if (tempmax < Math.max(f[left][k - 1] * a[one], g[left][k - 1] * a[one])) {
                        tempmax = Math.max(f[left][k - 1] * a[one], g[left][k - 1] * a[one]);
                    }
                    if (tempmin > Math.min(f[left][k - 1] * a[one], g[left][k - 1] * a[one])) {
                        tempmin = Math.min(f[left][k - 1] * a[one], g[left][k - 1] * a[one]);
                    }
                    f[one][kk] = tempmax;
                    g[one][kk] = tempmin;
                }
            }
        }
        //n选k最大的需要从最后一个最大的位置选
        long result = Long.MIN_VALUE;
        for (int one = k; one <= n; one++) {
            if (result < f[one][k]) {
                result = f[one][k];
            }
        }
        return result;

    }
}

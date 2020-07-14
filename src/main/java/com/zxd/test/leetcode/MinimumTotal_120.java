package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinimumTotal_120
 * @Description https://leetcode-cn.com/problems/triangle/
 * @Author xiaodong.zou
 * @Date 2020/7/14 20:21
 * @Version 1.0
 */
//120. 三角形最小路径和
//        给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
//        相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
//        例如，给定三角形：
//
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
//        说明：
//
//        如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
public class MinimumTotal_120 {

    public static void main(String[] args) {
        MinimumTotal_120 minimumTotal = new MinimumTotal_120();
        List<List<Integer>> triangle = new ArrayList<>(4);
        List<Integer> list1 = new ArrayList<>(1);
        list1.add(-1);
        List<Integer> list2 = new ArrayList<>(2);
        list2.add(2);
        list2.add(3);
        List<Integer> list3 = new ArrayList<>(3);
        list3.add(1);
        list3.add(-1);
        list3.add(3);
//        List<Integer> list4 = new ArrayList<>(3);
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
//        triangle.add(list4);
        System.out.println(minimumTotal.minimumTotal(triangle));

    }

    /**
     * 动态规划
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }
}

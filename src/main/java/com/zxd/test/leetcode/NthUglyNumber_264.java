package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NthUglyNumber_264
 * @Description https://leetcode-cn.com/problems/ugly-number-ii/
 * @Author xiaodong.zou
 * @Date 2021/4/11 20:18
 * @Version 1.0
 */
//264. 丑数 II
//        给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//        丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
//        示例 1：
//        输入：n = 10
//        输出：12
//        解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。

//        示例 2：
//        输入：n = 1
//        输出：1
//        解释：1 通常被视为丑数。
//
//
//        提示：
//        1 <= n <= 1690
public class NthUglyNumber_264 {

    List<Integer> uglyList = new ArrayList<>();
    int[] ugly = new int[]{2,3,5};
    public static void main(String[] args) {
        NthUglyNumber_264 nthUglyNumber_264 = new NthUglyNumber_264();
        System.out.println(nthUglyNumber_264.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}

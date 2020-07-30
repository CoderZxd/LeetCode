package com.zxd.test.leetcode;

/**
 * @ClassName IntegerBreak_343
 * @Description https://leetcode-cn.com/problems/integer-break/
 * @Author xiaodong.zou
 * @Date 2020/7/30 19:53
 * @Version 1.0
 */
//343. 整数拆分
//        给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
//        示例 1:
//
//        输入: 2
//        输出: 1
//        解释: 2 = 1 + 1, 1 × 1 = 1。
//        示例 2:
//
//        输入: 10
//        输出: 36
//        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//        说明: 你可以假设 n 不小于 2 且不大于 58。
public class IntegerBreak_343 {

    public static void main(String[] args) {

        IntegerBreak_343 integerBreak = new IntegerBreak_343();
        System.out.println(integerBreak.integerBreak(10));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}

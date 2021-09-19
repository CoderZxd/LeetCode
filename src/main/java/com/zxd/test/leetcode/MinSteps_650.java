package com.zxd.test.leetcode;

/**
 * @ClassName MinSteps_650
 * @Description https://leetcode-cn.com/problems/2-keys-keyboard/
 * @Author xiaodong.zou
 * @Date 2021/9/19 21:25
 * @Version 1.0
 */
//650. 只有两个键的键盘
//        最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
//
//        Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
//        Paste（粘贴）：粘贴 上一次 复制的字符。
//        给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
//
//
//
//        示例 1：
//
//        输入：3
//        输出：3
//        解释：
//        最初, 只有一个字符 'A'。
//        第 1 步, 使用 Copy All 操作。
//        第 2 步, 使用 Paste 操作来获得 'AA'。
//        第 3 步, 使用 Paste 操作来获得 'AAA'。
//        示例 2：
//
//        输入：n = 1
//        输出：0
//
//
//        提示：
//
//        1 <= n <= 1000
public class MinSteps_650 {

    public static void main(String[] args) {
        MinSteps_650 minSteps_650 = new MinSteps_650();
//        System.out.println(minSteps_650.minSteps(1));
//        System.out.println(minSteps_650.minSteps(2));
//        System.out.println(minSteps_650.minSteps(3));
//        System.out.println(minSteps_650.minSteps(4));
//        System.out.println(minSteps_650.minSteps(5));
//        System.out.println(minSteps_650.minSteps(6));
//        System.out.println(minSteps_650.minSteps(7));
//        System.out.println(minSteps_650.minSteps(8));
//        System.out.println(minSteps_650.minSteps(9));
        System.out.println(minSteps_650.minSteps(10));
    }

    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}

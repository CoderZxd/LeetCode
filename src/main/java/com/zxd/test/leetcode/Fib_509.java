package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/fibonacci-number/
 * @Author zouxiaodong
 * @Date 2021/01/04 9:13
 */
//509. 斐波那契数
//        斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//        F(0) = 0，F(1) = 1
//        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//        给你 n ，请计算 F(n) 。
//
//        示例 1：
//        输入：2
//        输出：1
//        解释：F(2) = F(1) + F(0) = 1 + 0 = 1
//
//        示例 2：
//        输入：3
//        输出：2
//        解释：F(3) = F(2) + F(1) = 1 + 1 = 2
//
//        示例 3：
//        输入：4
//        输出：3
//        解释：F(4) = F(3) + F(2) = 2 + 1 = 3
//
//        提示：
//        0 <= n <= 30
public class Fib_509 {

    public static void main(String[] args) {
        Fib_509 fib_509 = new Fib_509();
        System.out.println(fib_509.fib(2));
        System.out.println(fib_509.fib(3));
        System.out.println(fib_509.fib(4));
    }

    public int fib(int n) {
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * @Author zouxiaodong
     * @Description 动态规划
     * @Date 2021/01/04 9:20
     * @Param [n]
     * @return int
     **/
    public int fib_dp(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}

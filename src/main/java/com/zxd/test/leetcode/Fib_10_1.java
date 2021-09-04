package com.zxd.test.leetcode;

/**
 * @ClassName Fib_10_1
 * @Description https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @Author xiaodong.zou
 * @Date 2021/9/4 11:02
 * @Version 1.0
 */
//剑指 Offer 10- I. 斐波那契数列
//        写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
//        F(0) = 0,   F(1) = 1
//        F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//        斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
//        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
//        示例 1：
//
//        输入：n = 2
//        输出：1
//        示例 2：
//
//        输入：n = 5
//        输出：5
//
//
//        提示：
//
//        0 <= n <= 100
public class Fib_10_1 {

    public static void main(String[] args) {
        Fib_10_1 fib_10_1 = new Fib_10_1();
        System.out.println(fib_10_1.fib(43));
        System.out.println(fib_10_1.fib_1(43));
    }

    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public int fib_1(int n) {
        if(n<=1){
            return n;
        }
        int pre=0;
        int before=1;
        int current=0;
        for(int i=2;i<=n;i++){
            current=(pre+before)%1000000007;
            pre=before;
            before=current;
        }
        return current;
    }
}

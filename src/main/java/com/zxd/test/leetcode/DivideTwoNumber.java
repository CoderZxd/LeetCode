package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: 29. 两数相除
 * @Version 1.0
 * @create 2019-03-11 23:26
 **/

//        给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//        返回被除数 dividend 除以除数 divisor 得到的商。
//
//        示例 1:
//
//        输入: dividend = 10, divisor = 3
//        输出: 3

//        示例 2:
//
//        输入: dividend = 7, divisor = -3
//        输出: -2
//        说明:
//
//        被除数和除数均为 32 位有符号整数。
//        除数不为 0。
//        假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
public class DivideTwoNumber {
    public static void main(String[] args){
        System.out.println(divide(10,3));
        System.out.println(divide(7,-3));
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        int abDividend = Math.abs(dividend);
        int abDivisor = Math.abs(divisor);
        int result = 0;
        while (abDividend - abDivisor >= 0){
            abDividend -= abDivisor;
            result++;
        }
        if(dividend*divisor<0){
            result = -result;
        }
        return result;
    }
}

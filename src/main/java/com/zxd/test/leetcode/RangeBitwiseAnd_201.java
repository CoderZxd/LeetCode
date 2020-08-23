package com.zxd.test.leetcode;

/**
 * @ClassName RangeBitwiseAnd_201
 * @Description https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * @Author xiaodong.zou
 * @Date 2020/8/23 12:11
 * @Version 1.0
 */
//201. 数字范围按位与
//        给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
//
//        示例 1:
//
//        输入: [5,7]
//        输出: 4
//        示例 2:
//
//        输入: [0,1]
//        输出: 0
public class RangeBitwiseAnd_201 {

    public static void main(String[] args) {
        RangeBitwiseAnd_201 rangeBitwiseAnd_201 = new RangeBitwiseAnd_201();
        System.out.println(rangeBitwiseAnd_201.rangeBitwiseAnd(5,7));
    }

//    方法一：位移
//            思路
//
//    鉴于上述问题的陈述，我们的目的是求出两个给定数字的二进制字符串的公共前缀，这里给出的第一个方法是采用位移操作。
//
//    我们的想法是将两个数字不断向右移动，直到数字相等，即数字被缩减为它们的公共前缀。然后，通过将公共前缀向左移动，将零添加到公共前缀的右边以获得最终结果。
//
//
//
//    算法
//
//    如上述所说，算法由两个步骤组成：
//
//    我们通过右移，将两个数字压缩为它们的公共前缀。在迭代过程中，我们计算执行的右移操作数。
//    将得到的公共前缀左移相同的操作数得到结果。
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}

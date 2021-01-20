package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @Author zouxiaodong
 * @Date 2021/01/20 10:53
 */
//628. 三个数的最大乘积
//        给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//        示例 1:
//
//        输入: [1,2,3]
//        输出: 6
//        示例 2:
//
//        输入: [1,2,3,4]
//        输出: 24
//        注意:
//
//        给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
//        输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
public class MaximumProduct_628 {

    public static void main(String[] args) {

    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}

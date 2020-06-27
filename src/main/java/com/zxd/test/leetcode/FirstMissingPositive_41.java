package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @ClassName FirstMissingPositive_41
 * @Description https://leetcode-cn.com/problems/first-missing-positive/
 * @Author xiaodong.zou
 * @Date 2020/6/27 8:38
 * @Version 1.0
 */
//41. 缺失的第一个正数
//        给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//
//
//
//        示例 1:
//
//        输入: [1,2,0]
//        输出: 3
//        示例 2:
//
//        输入: [3,4,-1,1]
//        输出: 2
//        示例 3:
//
//        输入: [7,8,9,11,12]
//        输出: 1
public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        FirstMissingPositive_41 firstMissingPositive = new FirstMissingPositive_41();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{4,3,2,1,-1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{4,1,2,0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,2,3,4,6,7,4,9}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{3}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{-1,-2}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,2}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{-10,-3,-100,-1000,-239,1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1000,-1}));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

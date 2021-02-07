package com.zxd.test.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/non-decreasing-array/
 * @Author zouxiaodong
 * @Date 2021/02/07 9:07
 */
//665. 非递减数列
//        给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//        我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
//
//        示例 1:
//        输入: nums = [4,2,3]
//        输出: true
//        解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

//        示例 2:
//        输入: nums = [4,2,1]
//        输出: false
//        解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
//
//        说明：
//        1 <= n <= 10 ^ 4
//        - 10 ^ 5 <= nums[i] <= 10 ^ 5
public class CheckPossibility_665 {

    public static void main(String[] args) {
        CheckPossibility_665 checkPossibility_665 = new CheckPossibility_665();
        System.out.println(checkPossibility_665.checkPossibility(new int[]{4,2,3}));
//        System.out.println(checkPossibility_665.checkPossibility(new int[]{4,2,1}));
    }

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                nums[i] = y;
                if (isSorted(nums)) {
                    return true;
                }
                nums[i] = x; // 复原
                nums[i + 1] = x;
                return isSorted(nums);
            }
        }
        return true;
    }

    public boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

}

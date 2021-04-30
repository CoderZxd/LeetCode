package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode-cn.com/problems/single-number-ii/
 * @Author zouxiaodong
 * @Date 2021/04/30 14:03
 */
//137. 只出现一次的数字 II
//        给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
//        示例 1：
//        输入：nums = [2,2,3,2]
//        输出：3

//        示例 2：
//        输入：nums = [0,1,0,1,0,1,99]
//        输出：99
//
//        提示：
//        1 <= nums.length <= 3 * 10^4
//        -2^31 <= nums[i] <= 2^31 - 1
//        nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
//
//        进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
public class SingleNumber_137 {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    public int singleNumber_1(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}

package com.zxd.test.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description https://leetcode-cn.com/problems/132-pattern/
 * @Author zouxiaodong
 * @Date 2021/03/24 9:16
 */
//456. 132模式
//        给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//        注意：n 的值小于15000。
//
//        示例1:
//        输入: [1, 2, 3, 4]
//        输出: False
//        解释: 序列中不存在132模式的子序列。

//        示例 2:
//        输入: [3, 1, 4, 2]
//        输出: True
//        解释: 序列中有 1 个132模式的子序列： [1, 4, 2].

//        示例 3:
//        输入: [-1, 3, 2, 0]
//        输出: True
//        解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
public class Find132pattern_456 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }
}

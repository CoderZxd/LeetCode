package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/increasing-subsequences/
 * @Author zouxiaodong
 * @Date 2020/08/25 8:26
 */
//491. 递增子序列
//        给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
//
//        示例:
//
//        输入: [4, 6, 7, 7]
//        输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
//        说明:
//
//        给定数组的长度不会超过15。
//        数组中的整数范围是 [-100,100]。
//        给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
public class FindSubsequences_491 {

    public static void main(String[] args) {
        FindSubsequences_491 findSubsequences = new FindSubsequences_491();
        findSubsequences.findSubsequences(new int[]{4,6,7,7});
    }
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}

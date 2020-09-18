package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/permutations-ii/
 * @Author zouxiaodong
 * @Date 2020/09/18 8:14
 */
//47. 全排列 II
//        给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//        示例:
//
//        输入: [1,1,2]
//        输出:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]
public class PermuteUnique_47 {

    List<List<Integer>> resultList = new ArrayList<>();

    List<Integer> tempList = new ArrayList<>();

    boolean[] vis;

    public static void main(String[] args) {
        PermuteUnique_47 permuteUnique47 = new PermuteUnique_47();
        System.out.println(permuteUnique47.permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, resultList, 0, tempList);
        return resultList;
    }

    public void backtrack(int[] nums, List<List<Integer>> resultList, int index, List<Integer> tempList) {
        if (index == nums.length) {
            resultList.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            tempList.add(nums[i]);
            vis[i] = true;
            backtrack(nums, resultList, index + 1, tempList);
            vis[i] = false;
            tempList.remove(index);
        }
    }
}

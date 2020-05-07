package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName CombinationSum_39
 * @Description https://leetcode-cn.com/problems/combination-sum/
 * @Author xiaodong.zou
 * @Date 2020/5/6 22:42
 * @Version 1.0
 */
//39. 组合总和
//        给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。
//        示例 1:
//
//        输入: candidates = [2,3,6,7], target = 7,
//        所求解集为:
//        [
//        [7],
//        [2,2,3]
//        ]
//        示例 2:
//
//        输入: candidates = [2,3,5], target = 8,
//        所求解集为:
//        [
//        [2,2,2,2],
//        [2,3,3],
//        [3,5]
//        ]
public class CombinationSum_39 {

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{2,3,5},8);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(10);
        dfs(new LinkedList<Integer>(), 0, candidates, target,res);
        return res;
    }

    private static void dfs(LinkedList<Integer> list, int pre, int[] candidates, int target,List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pre; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(list, i, candidates, target - candidates[i],res);
            list.removeLast();
        }
    }
}

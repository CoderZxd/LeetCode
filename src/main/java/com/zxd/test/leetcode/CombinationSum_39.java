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
        combinationSum(new int[]{2,3,5},8);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>(10);
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates,len,target,0,new LinkedList<Integer>(),resultList);
        return resultList;
    }

//    回溯算法的框架：
//
//    result = []
//    def backtrack(路径, 选择列表):
//        if 满足结束条件:
//            result.add(路径)
//            return
//
//        for 选择 in 选择列表:
//            做选择
//            backtrack(路径, 选择列表)
//            撤销选择

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private static void dfs(int[] candidates,int len,int residue,int begin, LinkedList<Integer> path,List<List<Integer>> res){
        if(residue == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=begin;i<len;i++){
            if(residue-candidates[i]<0){
                break;
            }
            path.add(candidates[i]);
            System.out.println("before:"+path);
            dfs(candidates,len,residue-candidates[i],i,path,res);
            path.removeLast();
            System.out.println("after:"+path);
        }
    }
}

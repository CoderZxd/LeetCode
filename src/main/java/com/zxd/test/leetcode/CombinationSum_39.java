package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
        for(int i=0;i<len;i++){
            List<Integer> tempList = new ArrayList<>(10);
            deal(tempList,target,candidates,i);
            if(tempList.isEmpty()){
               continue;
            }
            resultList.add(tempList);
        }
        return resultList;
    }

    private static void deal(List<Integer> temp,int target,int[] candidates,int index){
        int len = candidates.length;
        for(int i=0;i<len;i++){
            if(candidates[i] == target){
                temp.add(target);
                return;
            }
        }
        int tempTarget = target - candidates[index];
        if(tempTarget < 0){
            temp.clear();
            return;
        }
        temp.add(candidates[index]);
        deal(temp,tempTarget,candidates,index);
    }
}

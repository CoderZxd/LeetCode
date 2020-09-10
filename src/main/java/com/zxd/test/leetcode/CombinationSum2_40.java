package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CombinationSum2_40
 * @Description https://leetcode-cn.com/problems/combination-sum-ii/
 * @Author xiaodong.zou
 * @Date 2020/9/10 22:51
 * @Version 1.0
 */
//40. 组合总和 II
//        给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。
//        示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        所求解集为:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        示例 2:
//
//        输入: candidates = [2,5,2,1,2], target = 5,
//        所求解集为:
//        [
//        [1,2,2],
//        [5]
//        ]
public class CombinationSum2_40 {

    public static void main(String[] args) {
        CombinationSum2_40 combinationSum2_40 = new CombinationSum2_40();
        List<List<Integer>> resutlList = combinationSum2_40.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
//        List<List<Integer>> resutlList = combinationSum2_40.combinationSum2(new int[]{2,5,2,1,2},5);
        System.out.println(resutlList);
    }

    List<List<Integer>> resultList = new ArrayList<>();

    List<Integer> tempList = new ArrayList<>();

    /**
     * 回溯
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return resultList;
    }

    private void dfs(int[] candidates,int val,int index){
        if(val == 0){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        if(val < 0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            //去重
            if(i>index&&candidates[i]==candidates[i-1]){
                continue;
            }
            tempList.add(candidates[i]);
            dfs(candidates,val-candidates[i],i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}

package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/combination-sum-iii/
 * @Author zouxiaodong
 * @Date 2020/09/11 8:04
 */
//216. 组合总和 III
//        找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//        说明：
//
//        所有数字都是正整数。
//        解集不能包含重复的组合。
//        示例 1:
//
//        输入: k = 3, n = 7
//        输出: [[1,2,4]]
//        示例 2:
//
//        输入: k = 3, n = 9
//        输出: [[1,2,6], [1,3,5], [2,3,4]]
public class CombinationSum3_216 {

    private List<List<Integer>> resultList = new ArrayList<>();

    private List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum3_216 combinationSum3 = new CombinationSum3_216();
//        List<List<Integer>> result = combinationSum3.combinationSum3(3,7);
//        List<List<Integer>> result = combinationSum3.combinationSum3(3,9);
        List<List<Integer>> result = combinationSum3.combinationSum3(2,18);
        System.out.println(result);
    }

    /**
     * @Author zouxiaodong
     * @Description 回溯，注意 “组合中只允许含有 1 - 9 的正整数” 的条件
     * @Date 2020/09/11 8:30
     * @Param [k, n]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n,1,k);
        return resultList;
    }

    private void dfs(int val,int index,int k){
        if(val == 0 && tempList.size() == k){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        if(val <= 0 || tempList.size() >= k){
            return;
        }
        for(int i= index;i<10;i++){
            tempList.add(i);
            dfs(val-i,i+1,k);
            tempList.remove(tempList.size()-1);
        }
    }
}

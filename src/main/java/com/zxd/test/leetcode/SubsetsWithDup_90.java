package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/subsets-ii/
 * @Author zouxiaodong
 * @Date 2021/03/31 9:11
 */
//90. 子集 II
//        给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//        解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//        示例 1：
//        输入：nums = [1,2,2]
//        输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

//        示例 2：
//        输入：nums = [0]
//        输出：[[],[0]]
//
//        提示：
//        1 <= nums.length <= 10
//        -10 <= nums[i] <= 10
public class SubsetsWithDup_90 {

    private List<List<Integer>> resultList = new ArrayList<>();

    private List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        SubsetsWithDup_90 subsetsWithDup_90 = new SubsetsWithDup_90();
        System.out.println(subsetsWithDup_90.subsetsWithDup(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return resultList;
    }

    //回溯
    private void backtrack(int[] nums,int index){
        resultList.add(new ArrayList<>(tempList));
        for(int i=index;i<nums.length;i++){
            //去除重复数据即重复结果
            if(i != index && nums[i] == nums[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            backtrack(nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}

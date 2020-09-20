package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subsets_78
 * @Description https://leetcode-cn.com/problems/subsets/
 * @Author xiaodong.zou
 * @Date 2020/9/20 12:44
 * @Version 1.0
 */
//78. 子集
//        给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入: nums = [1,2,3]
//        输出:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
public class Subsets_78 {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        Subsets_78 subsets_78 = new Subsets_78();
        System.out.println(subsets_78.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,tempList);
        return result;
    }

    private void dfs(int[] nums,int index,List<Integer> tempList){
        result.add(new ArrayList<>(tempList));
        for(int i=index;i<nums.length;i++){
            tempList.add(nums[i]);
            dfs(nums,i+1,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}

package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//46. 全排列((https://leetcode-cn.com/problems/permutations/)
//        给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
public class Permute_46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4,5}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>(10);
        int len = nums.length;
        if(len == 1){
            List<Integer> tempList = new ArrayList<>(1);
            tempList.add(nums[0]);
            resultList.add(tempList);
            return resultList;
        }
        Set<List<Integer>> resultSet = new HashSet<>(16);
        for(int start = 0; start < len; start++){
            for(int next = 0; next < len; next++){
                if(start != next){
                    List<Integer> tempList = new ArrayList<>(10);
                    tempList.add(nums[start]);
                    tempList.add(nums[next]);
                    for(int i=0;i<len;i++){
                        if(i != start && i != next){
                            tempList.add(nums[i]);
                        }
                    }
                    resultSet.add(tempList);
                }
                if(start != next){
                    List<Integer> tempList = new ArrayList<>(10);
                    tempList.add(nums[start]);
                    tempList.add(nums[next]);
                    for(int i=len-1;i>=0;i--){
                        if(i != start && i != next){
                            tempList.add(nums[i]);
                        }
                    }
                    resultSet.add(tempList);
                }
            }
        }
        resultList.addAll(resultSet);
        return resultList;
    }
}

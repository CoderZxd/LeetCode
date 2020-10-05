package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName FourSum_18
 * @Description https://leetcode-cn.com/problems/4sum/
 * @Author xiaodong.zou
 * @Date 2020/10/5 20:17
 * @Version 1.0
 */
//18. 四数之和
//        给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//        注意：
//
//        答案中不可以包含重复的四元组。
//
//        示例：
//
//        给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//        满足要求的四元组集合为：
//        [
//        [-1,  0, 0, 1],
//        [-2, -1, 1, 2],
//        [-2,  0, 0, 2]
//        ]
public class FourSum_18 {

    List<List<Integer>> resultList = new ArrayList<>();

    List<Integer> tempList = new ArrayList<>();



    /**
     * 回溯
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums,0,4,target);
        return resultList;
    }

    private void dfs(int[] nums,int index,int num, int target){
        if(num == 0){
            if(target == 0){
                resultList.add(new ArrayList<>(tempList));
            }
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(nums[i]>=0 && target<nums[i]){
                return;
            }
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            dfs(nums,i+1,num-1,target-nums[i]);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        FourSum_18 fourSum_18 = new FourSum_18();
//        List<List<Integer>> resultList = fourSum_18.fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
//        List<List<Integer>> resultList = fourSum_18.fourSum(new int[]{-2,-1,-1,1,1,2,2},0);
        List<List<Integer>> resultList = fourSum_18.fourSum(new int[]{-1,2,2,-5,0,-1,4},3);
        System.out.println(resultList);
    }
}

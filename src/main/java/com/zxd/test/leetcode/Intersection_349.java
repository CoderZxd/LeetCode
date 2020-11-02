package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Description https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Author zouxiaodong
 * @Date 2020/11/02 8:40
 */
//349. 两个数组的交集
//        给定两个数组，编写一个函数来计算它们的交集。
//
//
//
//        示例 1：
//
//        输入：nums1 = [1,2,2,1], nums2 = [2,2]
//        输出：[2]
//        示例 2：
//
//        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        输出：[9,4]
//
//
//        说明：
//
//        输出结果中的每个元素一定是唯一的。
//        我们可以不考虑输出结果的顺序。
public class Intersection_349 {

    public static void main(String[] args) {
        Intersection_349 intersection_349 = new Intersection_349();
//        System.out.println(intersection_349.intersection(new int[]{1,2,2,1},new int[]{2,2}));
        System.out.println(intersection_349.intersection(new int[]{4,9,5},new int[]{9,4,9,8,4}));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for(Integer ele:nums1){
            set.add(ele);
        }
        for(Integer ele:nums2){
            if(set.contains(ele)){
                resultSet.add(ele);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for(Integer ele:resultSet){
            result[i] = ele;
            i++;
        }
        return result;
    }
}

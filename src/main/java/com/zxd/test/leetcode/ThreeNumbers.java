package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description:给定一个排好序的数组，找出a+b=c这三个数都在该数组的组合
 * @Version 1.0
 * @create 2019-03-27 23:05
 **/
public class ThreeNumbers {
    public static void main(String[] args){
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
        getNumbers(numbers);
    }


    /**
     * class_name: getNumbers
     * param: [arrays]
     * describe: 时间复杂度为O(n^2)
     * creat_user: CoderZZ
     * creat_date: 2019-03-27
     * creat_time: 23:22
     **/
    private static void getNumbers(int[] arrays){
        if(arrays == null || arrays.length == 0){
            System.out.println("Null or empty array!");
        }
        Map<Integer,Integer> checkMap = new HashMap<Integer, Integer>(16);
        for(int i=0;i<arrays.length;i++){
            checkMap.put(arrays[i],i);
        }
        for(int i=0;i<arrays.length;i++){
            for(int j=i+1;j<arrays.length;j++){
                if(arrays[i]+arrays[j]>arrays[arrays.length-1]){
                    continue;
                }
                if(checkMap.containsKey(arrays[i]+arrays[j])){
                    System.out.println(arrays[i]+" "+arrays[j]+" "+(arrays[i]+arrays[j]));
                }
            }
        }
    }
}

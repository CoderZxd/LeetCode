package com.zxd.test.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName FindShortestSubArray_697
 * @Description https://leetcode-cn.com/problems/degree-of-an-array/
 * @Author xiaodong.zou
 * @Date 2021/2/20 22:32
 * @Version 1.0
 */
//697. 数组的度
//        给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//        你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
//        示例 1：
//        输入：[1, 2, 2, 3, 1]
//        输出：2
//        解释：
//        输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//        连续子数组里面拥有相同度的有如下所示:
//        [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//        最短连续子数组[2, 2]的长度为2，所以返回2.

//        示例 2：
//        输入：[1,2,2,3,1,4,2]
//        输出：6
//
//        提示：
//        nums.length 在1到 50,000 区间范围内。
//        nums[i] 是一个在 0 到 49,999 范围内的整数。
public class FindShortestSubArray_697 {

    public static void main(String[] args) {
        FindShortestSubArray_697 findShortestSubArray_697 = new FindShortestSubArray_697();
        System.out.println(findShortestSubArray_697.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray_697.findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
        System.out.println(findShortestSubArray_697.findShortestSubArray(new int[]{2,1}));
    }

    public int findShortestSubArray(int[] nums) {
        /**
         * range[*][0]元素出现次数
         * range[*][1]元素首次出现的位置
         * range[*][2]元素最后一次出现的位置
         */
        int[][] range = new int[50000][3];
        for(int i=0;i<nums.length;i++){
            if(range[nums[i]][0] == 0){
                range[nums[i]][1] = i;
            }
            range[nums[i]][2] = i;
            range[nums[i]][0]++;
        }
        Arrays.sort(range, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int maxNums = range[0][0];
        int result = range[0][2]-range[0][1]+1;
        for(int i=1;i<range.length;i++){
            if(range[i][0]==maxNums){
                result = Math.min(result,range[i][2]-range[i][1]+1);
            }
            break;
        }
        return result;
    }
}

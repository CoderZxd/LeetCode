package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/maximum-gap/
 * @Author zouxiaodong
 * @Date 2020/11/26 8:24
 */
//164. 最大间距
//        给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//        如果数组元素个数小于 2，则返回 0。
//
//        示例 1:
//        输入: [3,6,9,1]
//        输出: 3
//        解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。

//        示例 2:
//        输入: [10]
//        输出: 0
//        解释: 数组元素个数小于 2，因此返回 0。

//        说明:
//        你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
//        请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
public class MaximumGap_164 {

    public static void main(String[] args) {
        MaximumGap_164 maximumGap_164 = new MaximumGap_164();
        System.out.println(maximumGap_164.maximumGap(new int[]{3,6,9,1}));
        System.out.println(maximumGap_164.maximumGap(new int[]{1,10000000}));
    }

    public int maximumGap(int[] nums) {
        int len = nums.length;
        int result = 0;
        if(len<2){
            return result;
        }
        Arrays.sort(nums);
        for(int i=1;i<len;i++){
            if(nums[i]-nums[i-1]>result){
                result = nums[i]-nums[i-1];
            }
        }
        return result;
    }
}

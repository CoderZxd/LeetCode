package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description https://leetcode-cn.com/problems/majority-element-ii/
 * @Author zouxiaodong
 * @Date 2021/10/22 17:03
 */
//229. 求众数 II
//        给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
//        示例 1：
//        输入：[3,2,3]
//        输出：[3]

//        示例 2：
//        输入：nums = [1]
//        输出：[1]

//        示例 3：
//        输入：[1,1,1,3,3,2,2,2]
//        输出：[1,2]
//
//
//        提示：
//        1 <= nums.length <= 5 * 10^4
//        -10^9 <= nums[i] <= 10^9
//
//
//        进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
public class MajorityElement_229 {

    public static void main(String[] args) {
        MajorityElement_229 majorityElement_229 = new MajorityElement_229();
        List<Integer> integers = majorityElement_229.majorityElement(new int[]{3, 2, 3});
        System.out.println(integers);
    }

    /**
     * @Author zouxiaodong
     * @Description hash
     * @Date 2021/10/22 17:35
     * @Param [nums]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>(10);
        int len = nums.length;
        int times = len/3;
        Map<Integer,Integer> numToTimesMap = new HashMap<>(len);
        for(int num:nums){
            Integer time = numToTimesMap.getOrDefault(num, 0);
            if(time==times){
                result.add(num);
            }
            numToTimesMap.put(num,time+1);
        }
        return result;
    }
}

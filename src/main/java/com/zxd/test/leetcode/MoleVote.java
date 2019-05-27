package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2019-05-27 23:27
 **/
public class MoleVote {
    /**
     * 算法基础：摩尔投票法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int majority = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count++;
            } else {
                if (majority == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        int counter = 0;
        if (count <= 0) {
            return -1;
        } else {
            for (int num : nums) {
                if (num == majority) counter ++;
            }
        }
        if (counter > nums.length / 2) {
            return majority;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] test = new int[]{1,2,3,1,1,6,1};
        System.out.println(majorityElement(test));
    }
}

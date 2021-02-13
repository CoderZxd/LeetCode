package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindDisappearedNumbers_448
 * @Description https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @Author xiaodong.zou
 * @Date 2021/2/13 10:18
 * @Version 1.0
 */
//448. 找到所有数组中消失的数字
//        给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//        找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//        您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
//
//        示例:
//        输入:
//        [4,3,2,7,8,2,3,1]
//
//        输出:
//        [5,6]
public class FindDisappearedNumbers_448 {

    public static void main(String[] args) {
        FindDisappearedNumbers_448 findDisappearedNumbers_448 = new FindDisappearedNumbers_448();
        System.out.println(findDisappearedNumbers_448.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        int[] array = new int[len];
        for(int i=0;i<len;i++){
            array[nums[i]-1]++;
        }
        for(int i=0;i<len;i++){
            if(array[i] == 0){
                result.add(i+1);
            }
        }
        return result;
    }
}

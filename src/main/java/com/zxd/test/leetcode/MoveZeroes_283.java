package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/move-zeroes/
 * @Author zouxiaodong
 * @Date 2020/11/19 8:12
 */
//283. 移动零
//        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        示例:
//
//        输入: [0,1,0,3,12]
//        输出: [1,3,12,0,0]
//        说明:
//
//        必须在原数组上操作，不能拷贝额外的数组。
//        尽量减少操作次数。
public class MoveZeroes_283 {

    public static void main(String[] args) {
        MoveZeroes_283 moveZeroes_283 = new MoveZeroes_283();
//        int[] nums = new int[]{0,1,0,3,12};
        int[] nums = new int[]{0,1,0,3,12,0,0,1,2,3,4,5,0};
        moveZeroes_283.moveZeroes(nums);
        System.out.println(nums);
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i] != 0){
                continue;
            }
            int j=i+1;
            while (j<len && nums[j]==0){
                j++;
            }
            if(j==len){
                break;
            }
            int temp = nums[i];
            nums[i] =nums[j];
            nums[j]=temp;
        }
    }

    public void moveZeroes_1(int[] nums) {
        int len = nums.length;
        int j=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for(int i=j;i<len;i++){
            nums[i]=0;
        }
    }
}

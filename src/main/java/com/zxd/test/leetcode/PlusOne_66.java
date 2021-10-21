package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/plus-one/
 * @Author zouxiaodong
 * @Date 2021/10/21 10:23
 */
//66. 加一
//        给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//        你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//        示例 1：
//        输入：digits = [1,2,3]
//        输出：[1,2,4]
//        解释：输入数组表示数字 123。

//        示例 2：
//        输入：digits = [4,3,2,1]
//        输出：[4,3,2,2]
//        解释：输入数组表示数字 4321。

//        示例 3：
//        输入：digits = [0]
//        输出：[1]
//
//        提示：
//        1 <= digits.length <= 100
//        0 <= digits[i] <= 9
public class PlusOne_66 {

    public static void main(String[] args) {
        PlusOne_66 plusOne_66 = new PlusOne_66();
//        int[] ints = plusOne_66.plusOne(new int[]{1, 2, 3});
//        int[] ints1 = plusOne_66.plusOne(new int[]{4,3,2,1});
//        int[] ints2 = plusOne_66.plusOne(new int[]{0});
//        int[] ints3 = plusOne_66.plusOne(new int[]{9,9,9,9,9});
        int[] ints4 = plusOne_66.plusOne(new int[]{9,9,9,8,9});
        System.out.println();
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len-1]+1<10){
            digits[len-1]=digits[len-1]+1;
            return digits;
        }
        int carry = 1;
        digits[len-1]=0;
        for(int i=len-2;i>=0;i--){
            if(digits[i]+carry==10){
                digits[i]=0;
                carry=1;
            }else{
                digits[i]=digits[i]+carry;
                carry=0;
            }
        }
        if(carry != 0){
            int[] result = new int[len+1];
            result[0]=carry;
            System.arraycopy(digits,0,result,1,len);
            return result;
        }
        return digits;
    }
}

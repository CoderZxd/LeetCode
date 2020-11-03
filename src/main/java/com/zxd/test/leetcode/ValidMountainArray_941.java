package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/valid-mountain-array/
 * @Author zouxiaodong
 * @Date 2020/11/03 8:46
 */
//941. 有效的山脉数组
//        给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
//        让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
//        A.length >= 3
//        在 0 < i < A.length - 1 条件下，存在 i 使得：
//        A[0] < A[1] < ... A[i-1] < A[i]
//        A[i] > A[i+1] > ... > A[A.length - 1]
//
//        示例 1：
//
//        输入：[2,1]
//        输出：false
//        示例 2：
//
//        输入：[3,5,5]
//        输出：false
//        示例 3：
//
//        输入：[0,3,2,1]
//        输出：true
//
//
//        提示：
//
//        0 <= A.length <= 10000
//        0 <= A[i] <= 10000
public class ValidMountainArray_941 {

    public static void main(String[] args) {
        ValidMountainArray_941 validMountainArray_941 = new ValidMountainArray_941();
        System.out.println(validMountainArray_941.validMountainArray(new int[]{2,1}));
        System.out.println(validMountainArray_941.validMountainArray(new int[]{3,5,5}));
        System.out.println(validMountainArray_941.validMountainArray(new int[]{0,3,2,1}));
        System.out.println(validMountainArray_941.validMountainArray(new int[]{0,2,3,4,5,2,1,0}));
        System.out.println(validMountainArray_941.validMountainArray(new int[]{0,2,3,3,5,2,1,0}));
        System.out.println(validMountainArray_941.validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }

    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if(len<3){
            return false;
        }
        int maxIndex = 0;
        for(int i=0;i<len-1;i++){
            if(A[i] == A[i+1]){
                return false;
            } else if(A[i]>A[i+1]){
                if(i == 0){
                    return false;
                }
                maxIndex = i;
                break;
            }
        }
        for(int i=len-1;i>=1;i--){
            if(A[i] == A[i-1]){
                return false;
            }else if(A[i-1]<A[i]){
                if(maxIndex != i){
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public boolean validMountainArray_1(int[] A) {
        int len = A.length;
        int i = 0;
        // 递增扫描
        while (i + 1 < len && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == len - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < len && A[i] > A[i + 1]) {
            i++;
        }

        return i == len - 1;
    }
}

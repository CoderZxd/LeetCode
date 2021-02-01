package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/fair-candy-swap/
 * @Author zouxiaodong
 * @Date 2021/02/01 9:22
 */
//888. 公平的糖果棒交换
//        爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
//        因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
//        返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
//        如果有多个答案，你可以返回其中任何一个。保证答案存在。
//
//        示例 1：
//        输入：A = [1,1], B = [2,2]
//        输出：[1,2]

//        示例 2：
//        输入：A = [1,2], B = [2,3]
//        输出：[1,2]

//        示例 3：
//        输入：A = [2], B = [1,3]
//        输出：[2,3]

//        示例 4：
//        输入：A = [1,2,5], B = [2,4]
//        输出：[5,4]
//
//
//        提示：
//        1 <= A.length <= 10000
//        1 <= B.length <= 10000
//        1 <= A[i] <= 100000
//        1 <= B[i] <= 100000
//        保证爱丽丝与鲍勃的糖果总量不同。
//        答案肯定存在。
public class FairCandySwap_888 {

    public static void main(String[] args) {
        FairCandySwap_888 fairCandySwap_888 = new FairCandySwap_888();
//        int[] ints = fairCandySwap_888.fairCandySwap(new int[]{1, 1}, new int[]{2, 2});
//        int[] ints = fairCandySwap_888.fairCandySwap(new int[]{1, 2}, new int[]{2,3});
//        int[] ints = fairCandySwap_888.fairCandySwap(new int[]{2}, new int[]{1,3});
//        int[] ints = fairCandySwap_888.fairCandySwap(new int[]{1,2,5}, new int[]{2,4});
//        int[] ints = fairCandySwap_888.fairCandySwap(new int[]{2,4},new int[]{1,2,5});
//        int[] ints = fairCandySwap_888.fairCandySwap(new int[]{2},new int[]{2});
        int[] ints = fairCandySwap_888.fairCandySwap(new int[]{1,17,14,1,16},new int[]{26,11});
        System.out.println(ints);
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        int lenA = A.length;
        int lenB = B.length;
        if(lenA == lenB && lenA == 1){
            result[0] = A[0];
            result[1] = B[0];
            return result;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = 0;
        int sumB = 0;
        for(int a:A){
            sumA+=a;
        }
        for(int b:B){
            sumB+=b;
        }
        if(sumA>=sumB){
            int dValue = (sumA-sumB)/2;
            for(int i=0,j=0;i<lenA && j<lenB;){
                if(A[i] <= B[j] || A[i] - B[j] < dValue){
                    i++;
                }else if(A[i]-B[j] == dValue){
                    result[0] = A[i];
                    result[1] = B[j];
                    return result;
                }else {
                    j++;
                }
            }
        }
        if(sumA<sumB){
            int dValue = (sumB-sumA)/2;
            for(int i=0,j=0;i<lenA && j<lenB;){
                if(A[i] >= B[j] || B[j] - A[i] < dValue){
                    j++;
                }else if(B[j] - A[i] == dValue){
                    result[0] = A[i];
                    result[1] = B[j];
                    return result;
                }else {
                    i++;
                }
            }
        }
        return result;
    }
}

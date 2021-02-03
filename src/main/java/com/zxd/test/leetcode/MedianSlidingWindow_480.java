package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/sliding-window-median/
 * @Author zouxiaodong
 * @Date 2021/02/03 8:58
 */
//480. 滑动窗口中位数
//        中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
//
//        例如：
//        [2,3,4]，中位数是 3
//        [2,3]，中位数是 (2 + 3) / 2 = 2.5
//        给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
//
//        示例：
//        给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。

//        窗口位置                      中位数
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7      1
//        1 [3  -1  -3] 5  3  6  7      -1
//        1  3 [-1  -3  5] 3  6  7      -1
//        1  3  -1 [-3  5  3] 6  7       3
//        1  3  -1  -3 [5  3  6] 7       5
//        1  3  -1  -3  5 [3  6  7]      6
//        因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
//
//        提示：
//        你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
//        与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
public class MedianSlidingWindow_480 {

    public static void main(String[] args) {
        MedianSlidingWindow_480 medianSlidingWindow_480 = new MedianSlidingWindow_480();
//        double[] result = medianSlidingWindow_480.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
//        double[] result = medianSlidingWindow_480.medianSlidingWindow(new int[]{1,4,2,3},4);
        double[] result = medianSlidingWindow_480.medianSlidingWindow(new int[]{2147483647,2147483647},2);
        System.out.println(result);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int length = len - k + 1;
        double[] result = new double[length];
        int[] temp = new int[k];
        for(int i=0;i<length;i++){
            System.arraycopy(nums,i,temp,0,k);
            Arrays.sort(temp);
            if(k%2 == 0){
                int right = k/2;
                int left = right - 1;
                result[i] = ((double) temp[left]+(double) temp[right])/2.0;
            }else{
                result[i] = temp[k/2];
            }
        }
        return result;
    }
}

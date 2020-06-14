package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @ClassName FindBestValue_1300
 * @Description https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 * @Author xiaodong.zou
 * @Date 2020/6/14 9:17
 * @Version 1.0
 */
//1300. 转变数组后最接近目标值的数组和
//        给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
//
//        如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
//
//        请注意，答案不一定是 arr 中的数字。
//
//
//
//        示例 1：
//
//        输入：arr = [4,9,3], target = 10
//        输出：3
//        解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
//        示例 2：
//
//        输入：arr = [2,3,5], target = 10
//        输出：5
//        示例 3：
//
//        输入：arr = [60864,25176,27249,21296,20204], target = 56803
//        输出：11361
//
//
//        提示：
//
//        1 <= arr.length <= 10^4
//        1 <= arr[i], target <= 10^5
public class FindBestValue_1300 {

    public static void main(String[] args) {
//        System.out.println(findBestValue(new int[]{2,3,5},10));
//        System.out.println(findBestValue(new int[]{60864,25176,27249,21296,20204},56803));
//        System.out.println(findBestValue(new int[]{-9,2,3,4,5,6,7,8,9,10},30));
        System.out.println(findBestValue_1(new int[]{1547,83230,57084,93444,70879},71237));
    }

    /**
     * 官方题解：
     * 方法一：枚举 + 二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int findBestValue_1(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[n - 1];
        int ans = 0, diff = target;
        for (int i = 1; i <= r; ++i) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }

    /**
     * 12 / 18 个通过测试用例
     * TODO:主要是没有理解题目的真正意思
     * @param arr
     * @param target
     * @return
     */
    public static int findBestValue(int[] arr, int target) {
        int result = 0;
        int len = arr.length;
        if(len == 1){
            if(arr[0] <= target){
                return arr[0];
            }else{
                return target;
            }
        }
        Arrays.sort(arr);
        //平均数
        int average = Math.round((float) target/len);
        if(arr[0]>average){
            return average;
        }
        //折半查找平均数所在数组的位置
        int left = 0;
        int right = len-1;
        int mid = 0;
        while (left<=right){
            mid = (left+right)/2;
            if(arr[mid] == average){
                break;
            }else if(arr[mid] < average){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
//        System.out.println(mid);
        if(mid == 0){
            return arr[mid];
        }
        //从mid处开始计算
        int[] sumArray = new int[len];
        sumArray[0] = arr[0];
        for(int i=1;i<=mid;i++){
            sumArray[i] = arr[i] + sumArray[i-1];
        }
        int cha = Integer.MAX_VALUE;
        for(int i=mid;i<len;i++){
            sumArray[i] = arr[i] + sumArray[i-1];
            int sum = sumArray[i] + (len-i-1)*arr[i];
            if(Math.abs(sum-target)<cha){
                cha = Math.abs(sum-target);
                result = arr[i];
            }else{
                break;
            }
        }
        return result;
    }
}

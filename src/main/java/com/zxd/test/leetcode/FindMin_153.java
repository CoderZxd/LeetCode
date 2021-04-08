package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @Author zouxiaodong
 * @Date 2021/04/08 9:10
 */
//153. 寻找旋转排序数组中的最小值
//        已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
//        若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
//        若旋转 4 次，则可以得到 [0,1,2,4,5,6,7]
//        注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//        给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
//        示例 1：
//        输入：nums = [3,4,5,1,2]
//        输出：1
//        解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。

//        示例 2：
//        输入：nums = [4,5,6,7,0,1,2]
//        输出：0
//        解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。

//        示例 3：
//        输入：nums = [11,13,15,17]
//        输出：11
//        解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
//
//
//        提示：
//        n == nums.length
//        1 <= n <= 5000
//        -5000 <= nums[i] <= 5000
//        nums 中的所有整数 互不相同
//        nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
public class FindMin_153 {

    public static void main(String[] args) {
        FindMin_153 findMin_153 = new FindMin_153();
        System.out.println(findMin_153.findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin_153.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin_153.findMin(new int[]{11,13,15,17}));
        System.out.println(findMin_153.findMin(new int[]{3,1,2}));
        System.out.println(findMin_153.findMin(new int[]{2,1}));
        System.out.println(findMin_153.findMin(new int[]{9,10,1,2,3,4,5,6,7,8}));
    }

    public int findMin(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int l=0,r=len-1;
        if(nums[l]<nums[r]){
            return nums[l];
        }
        while (l<=r){
            if(l+1==r || l==r){
                return Math.min(nums[l],nums[r]);
            }
            int mid = (l+r)/2;
            //最小值在右半部分,有可能mid就是最小值,
            if(nums[l]<nums[mid]){
                l=mid;
            }else {
                //有可能mid就是最小值
                r=mid;
            }
        }
        return 0;
    }
}

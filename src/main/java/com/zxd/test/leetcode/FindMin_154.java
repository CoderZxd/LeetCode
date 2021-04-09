package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @Author zouxiaodong
 * @Date 2021/04/09 9:20
 */
//154. 寻找旋转排序数组中的最小值 II
//        已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
//        若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
//        若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
//        注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//        给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
//        示例 1：
//        输入：nums = [1,3,5]
//        输出：1

//        示例 2：
//        输入：nums = [2,2,2,0,1]
//        输出：0
//
//
//        提示：
//        n == nums.length
//        1 <= n <= 5000
//        -5000 <= nums[i] <= 5000
//        nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
//
//        进阶：
//        这道题是 寻找旋转排序数组中的最小值 的延伸题目。
//        允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
public class FindMin_154 {

    public static void main(String[] args) {
        FindMin_154 findMin_154 = new FindMin_154();
        System.out.println(findMin_154.findMin(new int[]{1,1}));
        System.out.println(findMin_154.findMin(new int[]{1,3,5}));
        System.out.println(findMin_154.findMin(new int[]{5,1,3}));
        System.out.println(findMin_154.findMin(new int[]{2,2,2,0,1}));
        System.out.println(findMin_154.findMin(new int[]{4,5,6,7,0,1,4}));
        System.out.println(findMin_154.findMin(new int[]{0,1,4,4,5,6,7}));
        System.out.println(findMin_154.findMin(new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,0,1,4}));
        System.out.println(findMin_154.findMin(new int[]{2,0,1,1,1}));
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
            //如果左右边界相等
            if(nums[l] == nums[r]){
                //如果左边界+1>左边界值 && 右边界-1>右边界值,则左右边界就是最小值,返回任意值即可;否则左边界+1,右边界-1
                if(nums[l+1]>nums[l] && nums[r-1]>nums[r]){
                    return nums[l];
                }else {
                    l++;
                    r--;
                    continue;
                }
            }
            int mid = (l+r)/2;
            //如果左边界值<mid值并且mid值小于等于右边界值或者左边界>=右边界值并且mid值小于右边界值,说明最小值在mid左边;否则最小值在mid右边
            if((nums[l]<nums[mid] && nums[mid] <=nums[r]) || (nums[l]>=nums[r] && nums[mid] <=nums[r])){
                r=mid;
            }else{
                l=mid;
            }
        }
        return 5001;
    }
}

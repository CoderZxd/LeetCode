package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Author zouxiaodong
 * @Date 2020/12/01 9:24
 */
//34. 在排序数组中查找元素的第一个和最后一个位置
//        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//        如果数组中不存在目标值 target，返回 [-1, -1]。
//
//        进阶：
//        你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//        示例 1：
//        输入：nums = [5,7,7,8,8,10], target = 8
//        输出：[3,4]

//        示例 2：
//        输入：nums = [5,7,7,8,8,10], target = 6
//        输出：[-1,-1]

//        示例 3：
//        输入：nums = [], target = 0
//        输出：[-1,-1]
//
//        提示：
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109
//        nums 是一个非递减数组
//        -109 <= target <= 109
public class SearchRange_34 {

    public static void main(String[] args) {
        SearchRange_34 searchRange_34 = new SearchRange_34();
//        int[] ints = searchRange_34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        int[] ints = searchRange_34.searchRange(new int[]{5,7,7,8,8,10}, 6);
        int[] ints = searchRange_34.searchRange(new int[]{}, 0);
//        int[] ints = searchRange_34.searchRange(new int[]{2,2}, 2);
        System.out.println(ints);
    }

    public int[] searchRange(int[] nums, int target) {
        //默认返回结果
        int[] result = new int[]{-1,-1};
        int len = nums.length;
        int firstIndex = -1;
        //折半查找
        for(int l=0,r=len-1;l<=r;){
            int mid = (l+r+1)/2;
            if(nums[mid] == target){
                firstIndex = mid;
                break;
            }else if(nums[mid]>target){
                r = mid-1;
            }else {
                l = mid + 1;
            }
        }
        //未找到直接返回结果
        if(firstIndex == -1){
            return result;
        }
        //双指针查找
        for(int l=firstIndex,r=firstIndex;l>=0 || r<len;){
            boolean flag = false;
            if(l>=0 && nums[l] == target){
                result[0] = l;
                l--;
                flag = true;
            }
            if(r<len && nums[r] == target){
                result[1] = r;
                r++;
                flag = true;
            }
            if(!flag){
                break;
            }
        }
        return result;
    }
}

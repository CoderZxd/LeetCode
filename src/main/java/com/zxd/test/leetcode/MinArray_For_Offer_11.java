package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @Author zouxiaodong
 * @Date 2020/07/22 8:29
 */
//剑指 Offer 11. 旋转数组的最小数字
//        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//        输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
//        例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
//        示例 1：
//
//        输入：[3,4,5,1,2]
//        输出：1
//        示例 2：
//
//        输入：[2,2,2,0,1]
//        输出：0
//        注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class MinArray_For_Offer_11 {

    public static void main(String[] args) {
        MinArray_For_Offer_11 minArrayForOffer = new MinArray_For_Offer_11();
        System.out.println(minArrayForOffer.minArray(new int[]{3,4,5,1,2}));
        System.out.println(minArrayForOffer.minArray(new int[]{2,2,2,0,1}));
    }

    public int minArray(int[] numbers) {
        int len = numbers.length;
        for(int i=1;i<len;i++){
            if(numbers[i]<numbers[0]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

    /**
     * @Author zouxiaodong
     * @Description 二分查找
     * @Date 2020/07/22 8:43
     * @Param [numbers]
     * @return int
     **/
    public int minArray_offical(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}

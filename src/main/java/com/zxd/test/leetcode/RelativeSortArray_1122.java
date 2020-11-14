package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName RelativeSortArray_1122
 * @Description https://leetcode-cn.com/problems/relative-sort-array/
 * @Author xiaodong.zou
 * @Date 2020/11/14 20:52
 * @Version 1.0
 */
//1122. 数组的相对排序
//        给你两个数组，arr1 和 arr2，
//        arr2 中的元素各不相同
//        arr2 中的每个元素都出现在 arr1 中
//        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//
//        示例：
//        输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//        输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
//        提示：
//        arr1.length, arr2.length <= 1000
//        0 <= arr1[i], arr2[i] <= 1000
//        arr2 中的元素 arr2[i] 各不相同
//        arr2 中的每个元素 arr2[i] 都出现在 arr1 中
public class RelativeSortArray_1122 {

    public static void main(String[] args) {
        RelativeSortArray_1122 relativeSortArray_1122 = new RelativeSortArray_1122();
        int[] result = relativeSortArray_1122.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6});
        System.out.println(result);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int[] resutlt = new int[len];
        int start=0;
        for(int ele:arr2){
            for(int i=0;i<len;i++){
                if(arr1[i] == -1){
                    continue;
                }
                if(arr1[i] == ele){
                    resutlt[start] = ele;
                    arr1[i] = -1;
                    start++;

                }
            }
        }
        List<Integer> rest = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(arr1[i] != -1){
                rest.add(arr1[i]);
            }
        }
        Collections.sort(rest);
        int restSize = rest.size();
        for(int i=0;i<restSize;i++){
            resutlt[len-restSize+i]=rest.get(i);
        }
        return resutlt;
    }
}

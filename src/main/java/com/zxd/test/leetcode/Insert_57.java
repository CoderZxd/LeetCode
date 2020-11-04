package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/insert-interval/
 * @Author zouxiaodong
 * @Date 2020/11/04 8:32
 */
//57. 插入区间
//        给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
//        在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//
//
//        示例 1：
//
//        输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//        输出：[[1,5],[6,9]]
//        示例 2：
//
//        输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        输出：[[1,2],[3,10],[12,16]]
//        解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
//
//        注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
public class Insert_57 {

    public static void main(String[] args) {
        Insert_57 insert_57 = new Insert_57();
//        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] newInterval = new int[]{4,8};
//        int[][] intervals = new int[][]{{1,3},{6,9}};
//        int[] newInterval = new int[]{2,5};
//        int[][] intervals = new int[][]{};
//        int[] newInterval = new int[]{5,7};
        int[][] intervals = new int[][]{{1,5}};
        int[] newInterval = new int[]{6,8};
        System.out.println(insert_57.insert(intervals,newInterval));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> intervalList = new ArrayList<>(intervals.length+1);
        for(int[] ele:intervals){
            intervalList.add(ele);
        }
        intervalList.add(newInterval);
        Collections.sort(intervalList, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> resultList = new ArrayList<>();
        int[] temp = null;
        for(int i=0,j=1;i<=intervals.length && j<= intervals.length;){
            if(temp == null && intervalList.get(i)[1]<intervalList.get(j)[0]){
                resultList.add(intervalList.get(i));
                i++;
                if(j+1>intervals.length){
                    resultList.add(intervalList.get(j));
                }
                j++;
                continue;
            }
            if(temp == null){
                temp = new int[]{intervalList.get(i)[0],Math.max(intervalList.get(i)[1],intervalList.get(j)[1])};
                i++;
                j++;
                if(j>intervals.length){
                    resultList.add(temp);

                }
                continue;
            }
            if(temp != null){
                if(temp[1]<intervalList.get(j)[0]){
                    resultList.add(temp);
                    temp = null;
                    i=j;
                    if(j+1>intervals.length){
                        resultList.add(intervalList.get(j));
                    }
                    j++;
                }else{
                    temp[1] = Math.max(temp[1],intervalList.get(j)[1]);
                    j++;
                    if(j>intervals.length){
                        resultList.add(temp);
                    }
                }
            }
        }
        int[][] result = new int[resultList.size()][2];
        for(int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}

package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * @Author zouxiaodong
 * @Date 2020/10/28 8:23
 */
//1207. 独一无二的出现次数
//        给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
//
//        如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
//
//
//
//        示例 1：
//
//        输入：arr = [1,2,2,1,1,3]
//        输出：true
//        解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
//        示例 2：
//
//        输入：arr = [1,2]
//        输出：false
//        示例 3：
//
//        输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//        输出：true
//
//
//        提示：
//
//        1 <= arr.length <= 1000
//        -1000 <= arr[i] <= 1000
public class UniqueOccurrences_1207 {

    public static void main(String[] args) {
        UniqueOccurrences_1207 uniqueOccurrences_1207 = new UniqueOccurrences_1207();
        System.out.println(uniqueOccurrences_1207.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences_1207.uniqueOccurrences(new int[]{1,2}));
        System.out.println(uniqueOccurrences_1207.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        if(len == 1){
            return true;
        }
        int[] times = new int[len];
        int time = 1;
        for(int j=1;j<len;j++){
            if(Integer.valueOf(arr[j]).equals(arr[j-1])){
                time++;
                continue;
            }else{
                if(times[time] != 0){
                    return false;
                }
                times[time] = time;
                time = 1;
            }
        }
        if(times[time] != 0){
            return false;
        }
        return true;
    }
}

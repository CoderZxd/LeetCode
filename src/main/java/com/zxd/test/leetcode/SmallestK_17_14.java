package com.zxd.test.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Author zouxiaodong
 * @Date 2021/09/03 9:17
 */
//面试题 17.14. 最小K个数
//        设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
//        示例：
//
//        输入： arr = [1,3,5,7,2,4,6,8], k = 4
//        输出： [1,2,3,4]
//        提示：
//
//        0 <= len(arr) <= 100000
//        0 <= k <= min(100000, len(arr))
public class SmallestK_17_14 {

    public static void main(String[] args) {

    }

    /**
     * @Author zouxiaodong
     * @Description 大根堆
     * @Date 2021/09/03 10:31
     * @Param [arr, k]
     * @return int[]
     **/
    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        int len = arr.length;
        if(k>0){
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for(int i=0;i<k;i++){
                queue.offer(arr[i]);
            }
            for(int i=k;i<len;i++){
                if(queue.peek()>arr[i]){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for(int i=0;i<k;i++){
                result[i] = queue.poll();
            }
        }
        return result;
    }
}

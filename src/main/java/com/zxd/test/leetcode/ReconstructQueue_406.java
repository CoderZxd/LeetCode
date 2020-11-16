package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @Author zouxiaodong
 * @Date 2020/11/16 8:55
 */
//406. 根据身高重建队列
//        假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
//
//        注意：
//        总人数少于1100人。
//
//        示例
//
//        输入:
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//        输出:
//        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
public class ReconstructQueue_406 {

    public static void main(String[] args) {
        ReconstructQueue_406 reconstructQueue_406 = new ReconstructQueue_406();
        int[][] result = reconstructQueue_406.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        System.out.println(result);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

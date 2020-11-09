package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Description https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @Author zouxiaodong
 * @Date 2020/11/09 8:52
 */
//973. 最接近原点的 K 个点
//        我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//
//        （这里，平面上两点之间的距离是欧几里德距离。）
//
//        你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
//
//
//
//        示例 1：
//
//        输入：points = [[1,3],[-2,2]], K = 1
//        输出：[[-2,2]]
//        解释：
//        (1, 3) 和原点之间的距离为 sqrt(10)，
//        (-2, 2) 和原点之间的距离为 sqrt(8)，
//        由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//        我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
//        示例 2：
//
//        输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//        输出：[[3,3],[-2,4]]
//        （答案 [[-2,4],[3,3]] 也会被接受。）
//
//
//        提示：
//
//        1 <= K <= points.length <= 10000
//        -10000 < points[i][0] < 10000
//        -10000 < points[i][1] < 10000
public class KClosest_973 {

    public static void main(String[] args) {
        KClosest_973 kClosest_973 = new KClosest_973();
//        int[][] result = kClosest_973.kClosest(new int[][]{{1,3},{-2,2}},1);
        int[][] result = kClosest_973.kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2);
        System.out.println(result);
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }


    public int[][] kClosest_Sort(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0]+o1[1]*o1[1] - o2[0]*o2[0] - o2[1]*o2[1];
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }
}

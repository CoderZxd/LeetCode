package com.zxd.test.leetcode;

import java.util.Random;

/**
 * @ClassName Solution_528
 * @Description https://leetcode-cn.com/problems/random-pick-with-weight/
 * @Author xiaodong.zou
 * @Date 2021/8/30 20:35
 * @Version 1.0
 */
//528. 按权重随机选择
//        给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
//
//        例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
//
//        也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
//
//
//
//        示例 1：

//        输入：
//        ["Solution","pickIndex"]
//        [[[1]],[]]
//        输出：
//        [null,0]
//        解释：
//        Solution solution = new Solution([1]);
//        solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
//        示例 2：
//
//        输入：
//        ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//        [[[1,3]],[],[],[],[],[]]
//        输出：
//        [null,1,1,1,1,0]
//        解释：
//        Solution solution = new Solution([1, 3]);
//        solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//        solution.pickIndex(); // 返回 1
//        solution.pickIndex(); // 返回 1
//        solution.pickIndex(); // 返回 1
//        solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//        由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//        [null,1,1,1,1,0]
//        [null,1,1,1,1,1]
//        [null,1,1,1,0,0]
//        [null,1,1,1,0,1]
//        [null,1,0,1,0,0]
//        ......
//        诸若此类。
//
//
//        提示：
//
//        1 <= w.length <= 10000
//        1 <= w[i] <= 10^5
//        pickIndex 将被调用不超过 10000 次
public class Solution_528 {

    int[] sums;

    public Solution_528(int[] w) {
        int len = w.length;
        sums = new int[len];
        sums[0]=w[0];
        for(int i=1;i<len;i++){
            sums[i]=w[i]+sums[i-1];

        }
    }

    public int pickIndex() {
        int random = new Random().nextInt(sums[sums.length-1])+1;
        int low = 0, high = sums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (sums[mid] < random) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }




    public static void main(String[] args) {
        Solution_528 solution_528 = new Solution_528(new int[]{3,14,1,7});
        for(int i=0;i<10000;i++){
            System.out.println(solution_528.pickIndex());
        }
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
<<<<<<< HEAD
 */


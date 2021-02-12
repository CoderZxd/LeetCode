package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GetRow_119
 * @Description https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @Author xiaodong.zou
 * @Date 2021/2/12 16:28
 * @Version 1.0
 */
//119. 杨辉三角 II
//        给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//        在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//        示例:
//        输入: 3
//        输出: [1,3,3,1]
//        进阶：
//        你可以优化你的算法到 O(k) 空间复杂度吗？
public class GetRow_119 {


    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> C = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }
}

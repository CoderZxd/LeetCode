package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Generate_118
 * @Description https://leetcode-cn.com/problems/pascals-triangle/
 * @Author xiaodong.zou
 * @Date 2020/12/6 13:18
 * @Version 1.0
 */
//118. 杨辉三角
//        给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//        在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//        示例:
//        输入: 5
//        输出:
//        [
//            [1],
//           [1,1],
//          [1,2,1],
//         [1,3,3,1],
//        [1,4,6,4,1]
//        ]
public class Generate_118 {

    public static void main(String[] args) {
        Generate_118 generate_118 = new Generate_118();
        System.out.println(generate_118.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>(numRows);
        for(int i=0;i<numRows;i++){
           List<Integer> temp = new ArrayList<>();
           for(int j=0;j<=i;j++){
               if(j == 0 || j == i){
                   temp.add(1);
               }else{
                   temp.add(resultList.get(i-1).get(j-1)+resultList.get(i-1).get(j));
               }
           }
           resultList.add(temp);
        }
        return resultList;
    }
}

package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description https://leetcode-cn.com/problems/4sum-ii/
 * @Author zouxiaodong
 * @Date 2020/11/27 9:18
 */
//454. 四数相加 II
//        给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
//        为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
//
//        例如:
//
//        输入:
//        A = [ 1, 2]
//        B = [-2,-1]
//        C = [-1, 2]
//        D = [ 0, 2]
//
//        输出:
//        2
//
//        解释:
//        两个元组如下:
//        1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//        2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
public class FourSumCount_454 {

    List<List<Integer>> resultList = new ArrayList<>();

    List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        FourSumCount_454 fourSumCount_454 = new FourSumCount_454();
        int[] A = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] B = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] C = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] D = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        int [] A = new int[]{-1,-1};
//        int [] B = new int[]{-1,1};
//        int [] C = new int[]{-1,1};
//        int [] D = new int[]{1,-1};
        System.out.println(fourSumCount_454.fourSumCount(A,B,C,D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int col = A.length;
        int[][] all = new int[4][col];
        all[0] = A;
        all[1] = B;
        all[2] = C;
        all[3] = D;
//        dfs(all,0,0);
//        return resultList.size();
        return fourSumCount_offical(A, B, C, D);
    }

    /**
     * @Author zouxiaodong
     * @Description 官方题解：hash表
     * @Date 2020/11/27 10:30
     * @Param [A, B, C, D]
     * @return int
     **/
    public int fourSumCount_offical(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        Map<Integer,Integer> countAB = new HashMap<>();
        for(int a:A){
            for(int b:B){
                countAB.put(a+b,countAB.getOrDefault(a+b,0)+1);
            }
        }
        for(int c:C){
            for(int d:D){
                if(countAB.containsKey(-c-d)){
                    ans+=countAB.get(-c-d);
                }
            }
        }
        return ans;
    }

    /**
     * @Author zouxiaodong
     * @Description 回溯：超出内存限制
     * @Date 2020/11/27 10:20
     * @Param [all, row, target]
     * @return void
     **/
    private void dfs(int[][] all,int row, int target){
        if(row > 3){
            if(target == 0){
                resultList.add(new ArrayList<>(tempList));
            }
            return;
        }
        for(int ele:all[row]){
            tempList.add(ele);
            dfs(all,row+1,target-ele);
            tempList.remove(tempList.size()-1);
        }
    }
}
